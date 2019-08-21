package br.com.atena.commons.utils;

import br.com.atena.exceptions.FileException;
import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ImageService {
    @Autowired
    private S3Utils s3Utils;

    public BufferedImage getJpgImageFromFile(MultipartFile uploadedFile) throws IOException {
        String ext = FilenameUtils.getExtension(uploadedFile.getOriginalFilename());
        if (!"png".equals(ext) && !"jpg".equals(ext)) {
            throw new FileException("Somente imagens PNG e JPG são permitidas");
        }

        BufferedImage img = ImageIO.read(uploadedFile.getInputStream());
        if ("png".equals(ext)) {
            img = pngToJpg(img);
        }
        return img;
    }

    public BufferedImage pngToJpg(BufferedImage img) {
        BufferedImage jpgImage = new BufferedImage(img.getWidth(), img.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        jpgImage.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
        return jpgImage;
    }

    public InputStream getInputStream(BufferedImage img) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(img, s3Utils.getFormatoImagem(), os);
            return new ByteArrayInputStream(os.toByteArray());
        } catch (IOException e) {
            throw new FileException("Erro ao ler arquivo");
        }
    }

    public BufferedImage cropSquare(BufferedImage sourceImg) {
        int min = (sourceImg.getHeight() <= sourceImg.getWidth()) ? sourceImg.getHeight() : sourceImg.getWidth();
        return Scalr.crop(
                sourceImg,
                (sourceImg.getWidth() / 2) - (min / 2),
                (sourceImg.getHeight() / 2) - (min / 2),
                min,
                min);
    }

    public BufferedImage resize(BufferedImage sourceImg, int size) {
        return Scalr.resize(sourceImg, Scalr.Method.ULTRA_QUALITY, size);
    }

    public BufferedImage resize(BufferedImage sourceImg) {
        return Scalr.resize(sourceImg, Scalr.Method.ULTRA_QUALITY, s3Utils.getTamanhoImagem());
    }
}