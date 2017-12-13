package com.home;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Use_Files {
	/**
	 * filechooser_Images fenêtre pour choisir une image
	 */
	public static String filechooser_Images(){
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Selection d'image");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    return selectedFile.getAbsolutePath();
		}
		else{
			return null;
		}
	}
	
	/**
	 * @return
	 * filechooser fenêtre pour choisir un Fichier

	 */
	public static String filechooser(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Selection Fichier");		
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    return selectedFile.getAbsolutePath();
		}
		else{
			return null;
		}
		
	}
	
	/**
	 * @param ImagePath
	 * @return
	 * methode auto resize de l'image avec label_image
	 */
	public static ImageIcon ResizeImage(String ImagePath,JLabel Labe_Image)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(Labe_Image.getWidth(), Labe_Image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
	public static ImageIcon ResizeImage_Panel(String ImagePath,JPanel Labe_Image)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(Labe_Image.getWidth(), Labe_Image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
	
	/**
	 * @param ImagePath
	 * @return
	 * methode return un object image
	 */
	public static ImageIcon Image(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        ImageIcon image = new ImageIcon(img);
        return image;
    }

}
