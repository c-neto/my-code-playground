package br.augustoliks;

import br.augustoliks.services.Impressor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ApplicationMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan(ApplicationMain.class.getPackage().getName());
        context.refresh();

        Impressor printer = context.getBean(Impressor.class);

        printer.mostrarInformacoes();
    }
}
