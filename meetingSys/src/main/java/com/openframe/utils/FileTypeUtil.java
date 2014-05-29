package com.openframe.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * 读取文件头判断文件类型
 * @author chenll
 *
 */
public class FileTypeUtil {

	private final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();

	static {
		getAllFileType(); // 初始化文件类型信息
	}

	private static void getAllFileType() {
		FILE_TYPE_MAP.put("jpg", "FFD8FF"); // JPEG (jpg)
		FILE_TYPE_MAP.put("png", "89504E47");// PNG (png)
		FILE_TYPE_MAP.put("gif", "47494638");// GIF (gif)
		FILE_TYPE_MAP.put("bmp", "424D"); // Windows Bitmap (bmp)
		FILE_TYPE_MAP.put("zip", "504B0304");// zip 压缩文件
	}

	public final static String getFileTypeByStream(byte[] b) {
		String filetypeHex = String.valueOf(getFileHexString(b));
		
		return filetypeHex;
//		Iterator<Entry<String, String>> entryiterator = FILE_TYPE_MAP
//				.entrySet().iterator();
//		while (entryiterator.hasNext()) {
//			Entry<String, String> entry = entryiterator.next();
//			String fileTypeHexValue = entry.getValue();
//			if (filetypeHex.toUpperCase().startsWith(fileTypeHexValue)) {
//				return entry.getKey();
//			}
//		}
//		return null;
	}

	public final static String getFileHexString(byte[] b) {
		StringBuilder stringBuilder = new StringBuilder();
		if (b == null || b.length <= 0) {
			return null;
		}
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public static final boolean isImage(File file) {
		boolean flag = false;
		try {
			BufferedImage bufreader = ImageIO.read(file);
			int width = bufreader.getWidth();
			int height = bufreader.getHeight();
			if (width == 0 || height == 0) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (IOException e) {
			flag = false;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public final static String getFileByFile(File file) {
		String filetype = null;
		byte[] b = new byte[50];
		try {
			InputStream is = new FileInputStream(file);
			is.read(b);
			filetype = getFileTypeByStream(b);
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filetype;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(getFileByFile(new File("D:\\soarsky\\test.txt")));
		FileTypeUtil s = new FileTypeUtil();
		System.out.println(s.getClass().getName());
		

	}

}
