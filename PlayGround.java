///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS info.picocli:picocli:4.7.1
//DEPS org.typemeta:funcj-parser:0.6.18

import picocli.CommandLine;
import java.util.concurrent.Callable;
import org.typemeta.funcj.parser.*;
import org.typemeta.funcj.data.Chr;
import static org.typemeta.funcj.parser.Text.*;

@CommandLine.Command(
        subcommands = {
            PlayGround.Hello.class
        },
        mixinStandardHelpOptions = true)
public class PlayGround {
    public static void main(String... args) {
        System.exit(new CommandLine(PlayGround.class).execute(args));
    }

    @CommandLine.Command(name = "hello")
    public static class Hello implements Callable<Void> {
        @Override
        public Void call() throws Exception {
            System.out.println("Hello world!");
            return null;
        }
    }
}
