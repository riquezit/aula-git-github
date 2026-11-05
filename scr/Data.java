import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = hoje.format(formatador);
        
        System.out.println("Data formatada: " + dataFormatada);
    }
}

