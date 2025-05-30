package P2.src.db;

import java.nio.file.FileSystems;

public class Parameters {

  private final static String sep = FileSystems.getDefault().getSeparator();
  private final static String usrDir = System.getProperty("user.dir");

  // path to resources subdirectory
  public final static String resDir = usrDir + sep + "src/P2/resources";
  public final static String dbFile = resDir + sep + "Olympia.db";
}
