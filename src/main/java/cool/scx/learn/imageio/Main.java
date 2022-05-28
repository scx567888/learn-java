package cool.scx.learn.imageio;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static ImageWriter getImageWriter(String formatName) {
        var writerIterator = ImageIO.getImageWritersByFormatName(formatName.trim().toLowerCase());
        var writer = writerIterator.next();
        if (writer == null) {
            throw new IllegalArgumentException("未找到对应格式的 ImageWriter , formatName : " + formatName);
        }
        return writer;
    }

    public static byte[] progressiveJPEG(byte[] sourceImageByte) throws IOException {
        //源文件
        var sourceImage = ImageIO.read(new ByteArrayInputStream(sourceImageByte));
        //图片 writer
        var jpegWriter = getImageWriter("jpeg");
        //参数
        var writeParam = jpegWriter.getDefaultWriteParam();
        //使用默认参数以启用渐进式图片
        writeParam.setProgressiveMode(ImageWriteParam.MODE_DEFAULT);
        //开始转换
        try (var b = new ByteArrayOutputStream(); var m = new MemoryCacheImageOutputStream(b)) {
            jpegWriter.setOutput(m);
            jpegWriter.write(null, new IIOImage(sourceImage, null, null), writeParam);
            jpegWriter.dispose();
            return b.toByteArray();
        }
    }

    public static void main(String[] args) throws IOException {
        var sourceFile =Path.of("C:\\Users\\worker\\Pictures\\Wallpaper\\img (3).png") ;
        var targetFile =Path.of("xxx.jpeg");
        var imageByte = progressiveJPEG(Files.readAllBytes(sourceFile));
        Files.write(targetFile, imageByte);
    }

}
