package id.co.backend.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/qrctl")
public class QrCtl {

    @PostMapping(value = "/generate/{heigh}/{weight}", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage getQRMandiri(@RequestBody String content, @PathVariable("heigh") int height, @PathVariable("weight") int width) throws IllegalStateException, WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
        System.out.println("masukkah : " + content);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
