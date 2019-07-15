package ovo.test;

import java.util.Arrays;
import java.util.Stack;

public class HTMLGenerator {

	private static Stack<String> stack;

	enum HTMLTag {
		table, tr, th, td
	}

	enum Type {
		Folder, File
	}

	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder();
		stack = new Stack<>();
		Folder photos1 = new Folder("Penting", Arrays.asList(new File[] { new File("foto formal.jpg") }));
		Folder photos2 = new Folder("Pemandangan", Arrays.asList(new File[] { new File("bogor panorama.jpg") }));
		File photo1 = new File("photo1.jpg");
		File photo2 = new File("photo2.jpg");
		Folder photos = new Folder("Photos", Arrays.asList(new Folder[] { photos1, photos2 }),
				Arrays.asList(new File[] { photo1, photo2 }));
		File video1 = new File("video1.mp4");
		File video2 = new File("video2.mp4");
		Folder videos = new Folder("Videos", Arrays.asList(new File[] { video1, video2 }));
		Folder root = new Folder("My Document", Arrays.asList(new Folder[] { photos, videos }),
				Arrays.asList(new File[] { new File("file1.docx") }));
		System.out.println(generate(root));
	}

	public static String generate(Folder root) {
		stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		// buka table tag
		sb.append(openTag(HTMLTag.table));
		// isi table tag
		sb.append("<tr><th>Name</th><th>Type</th></tr>");
		sb.append(method(root, 0));
		// tutup table tag
		sb.append(stack.pop());
		return sb.toString();
	}

	private static String method(Folder root, int level) {
		StringBuilder sb = new StringBuilder();
		// opening tr tag
		sb.append(openTag(HTMLTag.tr));

		// isi td tag yg folder
		sb.append(openTag(HTMLTag.td, getLevel(level))).append(root.name).append(stack.pop());
		sb.append(openTag(HTMLTag.td)).append(Type.Folder).append(stack.pop());

		// closing tr tag
		sb.append(stack.pop());

		// kalo punya subfolder, cetak mereka dulu
		if (root.subfolders != null) {
			for (Folder child : root.subfolders) {
				sb.append(method(child, level + 1));
			}
		}
		// isi td tag yg file
		if (root.files != null) {
			for (File file : root.files) {
				sb.append(openTag(HTMLTag.tr));
				sb.append(openTag(HTMLTag.td, getLevel(level + 1))).append(file.name).append(stack.pop());
				sb.append(openTag(HTMLTag.td)).append(Type.File).append(stack.pop());
				sb.append(stack.pop());
			}
		}

		return sb.toString();
	}

	private static String openTag(HTMLTag tag, String className) {
		stack.push(closeTag(tag));
		return "<".concat(tag.toString()).concat(" class=\"").concat(className).concat("\">");
	}

	private static String openTag(HTMLTag tag) {
		stack.push(closeTag(tag));
		return "<".concat(tag.toString()).concat(">");
	}

	private static String closeTag(HTMLTag tag) {
		return "</".concat(tag.toString()).concat(">");
	}

	private static String getLevel(int level) {
		return level == 0 ? "root" : "level-".concat(String.valueOf(level));
	}
}
