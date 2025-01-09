import java.io.File;

public class Configuration {

    public static StringBuilder getDriverPath() {

        StringBuilder driverPath = new StringBuilder();

        driverPath.append(getPath());
        driverPath.append("src");
        driverPath.append(File.separator);
        driverPath.append("test");
        driverPath.append(File.separator);
        driverPath.append("resources");
        driverPath.append(File.separator);
        System.out.println("Driver path    ===  " + driverPath);
        return driverPath;

    }

    public static String getChromeDriverPath() {
        StringBuilder jrePath = new StringBuilder();
        jrePath = getDriverPath();
        jrePath.append("chromedriver-131");
        jrePath.append(File.separator);
        jrePath.append("chromedriver.exe");

        //TODO if System is Linux would append its driver
        System.out.println("java    ===  " + jrePath);
        return jrePath.toString();
    }

    public static String getPath() {

        File f = new File(".");
        String path = f.getAbsolutePath();
        path = path.substring(0, path.length() - 1);

        System.err.println("path===========" + path);
        return path;
    }

}