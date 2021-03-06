package sample.file.watcher;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class DirectoryMonitor {

	// 참고 : 	https://docs.oracle.com/javase/tutorial/essential/io/examples/WatchDir.java
	// 			http://www.java2s.com/Tutorials/Java/java.nio.file/Path/Java_Path_register_WatchService_watcher_WatchEvent_Kind_lt_gt_events_.htm
	public static void main(String[] args) throws Exception {

		FileSystem fileSystem = FileSystems.getDefault();
		WatchService watchService = fileSystem.newWatchService();
		Path directory = Paths.get("D:\\tempDir");
		WatchEvent.Kind<?>[] events = { StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY };
		directory.register(watchService, events);
		while (true) {
			System.out.println("Waiting for a watch event");
			WatchKey watchKey = watchService.take();

			System.out.println("Path being watched: " + watchKey.watchable());
			System.out.println();

			if (watchKey.isValid()) {
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					System.out.println("Kind: " + event.kind());
					System.out.println("Context: " + event.context());
					System.out.println("Count: " + event.count());
					System.out.println();
				}

				boolean valid = watchKey.reset();
				if (!valid) {
					// The watchKey is not longer registered
				}
			}
		}
	}
}
