package com.ProjectTickets.ticket_system.model;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QrCodeGenerator {

    public static void generateQrCode(String uuid,String filePath) throws Exception{


        BitMatrix matrix = new MultiFormatWriter()
                .encode(uuid, BarcodeFormat.QR_CODE,500,500);
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        MatrixToImageWriter.writeToPath(matrix,"JPG", Paths.get(filePath));
    }
}
