import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.Policy;
import java.util.Calendar;

public class Logger {

    private static Logger log;
    private String direct = System.getProperty("user.dir") + "/logs/";

    private Logger() { }

    public static Logger getLogger() {
        Logger result = log;
        if(result != null) return result;

        synchronized (Logger.class) {
            if (log == null) return new Logger();
            return log;
        }
    }


    public void writeGameActionLog() {
    }

    public void writeClassInstanceLog(Class c) throws IOException {
        String toLogClassInst = direct+"/logClasses.txt";

        Method[] methods = c.getDeclaredMethods();
        String titleLog = "Class name: " + c.getName() + "\n";
        String logTxt = "";
        if (c.getName().equals("Demo")) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(toLogClassInst));
            writer.write("");
            writer.close();
            logTxt += "RUN GAME\n";
            Files.write(
                    Paths.get(toLogClassInst),
                    logTxt.getBytes(),
                    StandardOpenOption.APPEND);
            return;
        }
        logTxt += "-------------------------\n" + titleLog.toUpperCase() + "-------------------------\n";

        for (Method method: methods) {

            logTxt += "Name method: " + method.getName() + "\n";
            if (method.getParameters().length == 0) logTxt += "params empty \n";
            for (Parameter parameters: method.getParameters()) logTxt += "param: " + parameters + "\n";
            logTxt += "return type: " + method.getReturnType() + "\n";
            logTxt += "---------------------- \n";
        }
            logTxt += "date: " + Calendar.getInstance().getTime() + "\n";
            logTxt += "---------------------- \n";
            Files.write(
                    Paths.get(toLogClassInst),
                    logTxt.getBytes(),
                    StandardOpenOption.APPEND);
        }
}
