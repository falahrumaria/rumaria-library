package rumaria.test.ovo;

import java.util.List;

public class Folder {
	String name;
	List<Folder> subfolders;
	List<File> files;

	public Folder(String name, List<Folder> subfolders, List<File> files) {
		this(name, files);
		this.subfolders = subfolders;
	}

	public Folder(String name, List<File> files) {
		this(name);
		this.files = files;
	}

	public Folder(String name) {
		super();
		this.name = name;
	}

}
