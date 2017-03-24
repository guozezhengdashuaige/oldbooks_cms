package cn.cuilan.oldbooks.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * use the Google ZXing core create QR code
 *
 * @author zhang.yan
 * @date 2016年10月13日 上午12:02:01
 * @package cn.cuilan.oldbooks.utils
 * @file QRCodeByZXing.java
 */
public class QRCodeByZXing {

	// 配置文件名称
	private static final String PROPERTY_FILE_PATH = "/qr_code.properties";
	// 宽
	private static int width = Integer.parseInt(PropertiesUtil.getValue(PROPERTY_FILE_PATH, "QR_CODE_WIDTH"));
	// 高
	private static int height = Integer.parseInt(PropertiesUtil.getValue(PROPERTY_FILE_PATH, "QR_CODE_HEIGHT"));
	// 二维码图片文件后缀名
	private static String format = PropertiesUtil.getValue(PROPERTY_FILE_PATH, "QR_CODE_FORMAT");

	/**
	 * ZXing生成二维码图片
	 * 
	 * @param content
	 *            内容
	 * @param filePath
	 *            文件保存路径
	 * @param fileName
	 *            文件名
	 * @return 返回图片路径
	 */
	public static String createQRCode(String content, String filePath, String fileName) {
		// 定义二维码的参数
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// 定义编码
		hints.put(EncodeHintType.CHARACTER_SET, PropertiesUtil.getValue(PROPERTY_FILE_PATH, "QR_ENCODE"));
		// 定义纠错等级
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		// 定义图片边框，默认是5
		hints.put(EncodeHintType.MARGIN,
				Integer.parseInt(PropertiesUtil.getValue(PROPERTY_FILE_PATH, "QR_CODE_MARGIN")));
		// 二维码图片文件路径
		String qrCodePath = filePath + "/" + fileName + "." + format;
		// 生成二维码
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			Path file = new File(qrCodePath).toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			return qrCodePath;
		} catch (Exception e) {
			new RuntimeException("生成二维码失败！");
			return null;
		}
	}

	/**
	 * 解析二维码图片中的信息
	 * 
	 * @param filePathAndName
	 *            文件路径及文件名（全路径，如：D:/qrcode/1475162643074.png）
	 * @return 返回二维码图片中的文本信息
	 */
	public static String readQRCode(String filePathAndName) {
		// 二维码读取对象
		MultiFormatReader formatReader = new MultiFormatReader();
		try {
			// 创建二维码文件对象
			File file = new File(filePathAndName);
			// 创建二维码图片对象
			BufferedImage image = ImageIO.read(file);
			// 创建二维码二进制映射对象
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			// 定义二维码的参数
			Map<DecodeHintType, String> hints = new HashMap<DecodeHintType, String>();
			// 定义编码
			hints.put(DecodeHintType.CHARACTER_SET, PropertiesUtil.getValue(PROPERTY_FILE_PATH, "QR_ENCODE"));
			// 返回结果
			Result result = formatReader.decode(binaryBitmap, hints);
			return result.getText(); // 或 result.toString()
		} catch (Exception e) {
			new RuntimeException("解析二维码失败！");
			return null;
		}
	}

}
