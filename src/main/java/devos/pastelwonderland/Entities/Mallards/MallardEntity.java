package devos.pastelwonderland.Entities.Mallards;

import devos.pastelwonderland.PastelWonderland;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class MallardEntity extends AnimalEntity {
    private static final TrackedData<Integer> VARIANT;
    private static final Ingredient BREEDING_INGREDIENT;
    public float flapProgress;
    public float maxWingDeviation;
    public float prevMaxWingDeviation;
    public float prevFlapProgress;
    public float flapSpeed = 1.0F;

    public MallardEntity(EntityType<? extends MallardEntity> entityType, World world) {
        super(entityType, world);
        this.setHealth(6);
    }

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.5D);
    }

    public void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
//        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.4D));
        this.targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.0D, false, BREEDING_INGREDIENT));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(4, new MallardEntity.AttackGoal(this));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
//        this.targetSelector.add(8, new UniversalAngerGoal(this, true)); // TODO make groups of Mallard angery >>:(
    }

    static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(MallardEntity entity) {
            super(entity, 1.0D, true);
        }

        public boolean canStart() {
            return super.canStart() && !this.mob.hasPassengers();
        }

        public boolean shouldContinue() {
            if (this.mob.getRandom().nextInt(100) == 0) {
                this.mob.setTarget((LivingEntity)null);
                return false;
            } else {
                return super.shouldContinue();
            }
        }

        protected double getSquaredMaxAttackDistance(LivingEntity entity) {
            return (double)(4.0F + entity.getWidth());
        }
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return this.isBaby() ? dimensions.height : dimensions.height;
    }

    public MallardEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return (MallardEntity) PastelWonderland.MALLARD.create(serverWorld);
    }

    public void tickMovement() {
        super.tickMovement();
        this.prevFlapProgress = this.flapProgress;
        this.prevMaxWingDeviation = this.maxWingDeviation;
        this.maxWingDeviation = (float)((double)this.maxWingDeviation + (double)(this.onGround ? -1 : 4) * 0.3D);
        this.maxWingDeviation = MathHelper.clamp(this.maxWingDeviation, 0.0F, 1.0F);
        if (!this.onGround && this.flapSpeed < 1.0F) {
            this.flapSpeed = 1.0F;
        }

        this.flapSpeed = (float)((double)this.flapSpeed * 0.9D);
        Vec3d vec3d = this.getVelocity();
        if (!this.onGround && vec3d.y < 0.0D) {
            this.setVelocity(vec3d.multiply(1.0D, 0.6D, 1.0D));
        }

        this.flapProgress += this.flapSpeed * 2.0F;
        if (this.isTouchingWater()) {
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(20.0D);
        } else {
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.25D);
        }
    }

    public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
        return false;
    }

    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    public int getVariant() {
        return MathHelper.clamp((Integer)this.dataTracker.get(VARIANT), 0, 2);
    }

    public void setVariant(int variant) {
        this.dataTracker.set(VARIANT, variant);
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(VARIANT, Math.random() <= 0.5 ? 1 : 2);
    }

    public void writeCustomDataToTag(CompoundTag tag) {
        super.writeCustomDataToTag(tag);
        tag.putInt("Variant", this.getVariant());
    }

    public void readCustomDataFromTag(CompoundTag tag) {
        super.readCustomDataFromTag(tag);
        this.setVariant(tag.getInt("Variant"));
    }

    public void updatePassengerPosition(Entity passenger) {
        super.updatePassengerPosition(passenger);
        float f = MathHelper.sin(this.bodyYaw * 0.017453292F);
        float g = MathHelper.cos(this.bodyYaw * 0.017453292F);
        float h = 0.1F;
        float i = 0.0F;
        passenger.updatePosition(this.getX() + (double)(0.1F * f), this.getBodyY(0.5D) + passenger.getHeightOffset() + 0.0D, this.getZ() - (double)(0.1F * g));
        if (passenger instanceof LivingEntity) {
            ((LivingEntity)passenger).bodyYaw = this.bodyYaw;
        }

    }

    static {
        VARIANT = DataTracker.registerData(MallardEntity.class, TrackedDataHandlerRegistry.INTEGER);
        BREEDING_INGREDIENT = Ingredient.ofItems(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
    }
}