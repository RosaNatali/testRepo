package com.esprit.utils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Testl {

	public static void main(String[] args) {

		try {

			BufferedImage originalImage = ImageIO.read(new File(
					"C:\\TESTIn\\BillGates.JPG"));

			ImageIO.write(originalImage, "jpg", new File(
					"C:\\TESTIn\\BillGates.JPG"));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}