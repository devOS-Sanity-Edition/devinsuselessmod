package dev.hiitsdevin.pastelwonderland.Base;

import dev.hiitsdevin.pastelwonderland.PastelWonderland;
import net.fabricmc.api.ModInitializer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Capes {
    // is it dumb cape stuff time? it is dumb cape stuff time.
    private static final FileFilter fileFilter = file -> file.getName().endsWith(".png");
    public static final Path mainDir = Paths.get(PastelWonderland.MOD_ID);


    public static File[] grabAllCapeTextures() {

        return Objects.requireNonNull(PastelWonderland.mainDir.toFile().listFiles(fileFilter));
    }

    public static void writeDirectories() {
        try {
            if (!Files.exists(mainDir)) {
                PastelWonderland.logger.warn("\"" + mainDir.toString() + "\" directory does not exist, creating it now.");
                Files.createDirectory(mainDir);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void init() {
    }
}
