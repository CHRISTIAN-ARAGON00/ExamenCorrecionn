
import java.io.IOException;
import java.util.Scanner;

import Utilitario.Color;
import Utilitario.Utility;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Horario caHorario = new Horario();
    private static String caHorarioRutaDirectorio = ".\\src\\Horarioss";
     static String CA_NOMBRE = "christian daniel aragon pazmiño";
        static int CA_CEDULA = 1727060491;
        static String CA_CORREO = "CHRISTIAN.ARAGON@EPN.EDU.EC";
        static String caUsuario1 = "christian.aragon@epn.edu.ec";
        static String caClave1 = "1727060491";
        static String caUsuario2 = "profe";
        static String caClave2 = "1234";
        static boolean caValidarLogin = false;
        static int caContadorIntentos = 2;

    public static void main(String[] args) throws Exception {

        System.out.println();
        caHorario.caReadHorarioMedicos(caHorarioRutaDirectorio);
        System.out.println(Color.GREEN + "    - CEDULA: " + CA_CEDULA);
        System.out.println(Color.RED + "    - CORREO: " + CA_CORREO);
        System.out.println(Color.BOLD_BLUE + "    - NOMBRE: " + CA_NOMBRE);
        System.out.println();

        caLogearse(caUsuario1, caClave1, caUsuario2, caClave2, caValidarLogin, caContadorIntentos);
        
        System.out.println();
        System.out.println("1 Visualizar Medicos");
        System.out.println("2 Visualizar Especialidad");
        System.out.println("3 Visualizar Horario");
        System.out.println("4 Visualizar Horario de una especialidad ");
        System.out.println("0 SALIR");

    }
    private static void caLogearse(String caUsuario1, String caClave1, String caUsuario2, String caClave2,boolean caValidarLogin, int caContadorIntentos) throws IOException {
        String caUsuario;
        String caClave;
        while (!caValidarLogin) {
            System.out.println("------------------------");
            System.out.print("+ usuario : ");
            caUsuario = sc.nextLine();
            System.out.print("+ clave   : ");
            caClave = sc.nextLine();
            System.out.println("------------------------");
            System.out.println("*Nro de intentos: " + caContadorIntentos);
            System.out.println();
            if (caUsuario.equals(caUsuario1) && caClave.equals(caClave1)
                    || caUsuario.equals(caUsuario2) && caClave.equals(caClave2)) {
                caValidarLogin = true;
                caMenu(Utility.convertirAMayusculas(caUsuario));
            } else {
                caContadorIntentos--;
                if (caContadorIntentos == -1) {
                    System.out.println();
                    System.out.println("Lo sentimos tu usuario y clave son incorrectos ");
                    System.out.println();
                    System.out.println(" <<<<<<GRACIAS>>>>>> ");
                    System.out.println();
                    System.out.println();
                    System.exit(0);
                }
            }

        }
    }
    public static void caMenu(String caUsuario) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int caMenuInicial;

        do {
            System.out.println("--------------------------");
            System.out.println("Carga horaria de medico ");
            System.out.println("--------------------------");
            System.out.println("Usuario: "+ caUsuario.toUpperCase());
            System.out.println("");
            System.out.println("1 Visualizar Medicos");
            System.out.println("2 Visualizar Especialidad");
            System.out.println("3 Visualizar Horario");
            System.out.println("4 Visualizar Horario de una asignatura");
            System.out.println("0 SALIR");
            
            caMenuInicial= Utility.caObtenerUnNumeroPositivo(" Seleccione una opcion: ");
        
            switch (caMenuInicial) {
                case 1: Utility.clearTerminal();
                        System.out.println("[+] Listado de medicos");
                        System.out.println();
                        caHorario.caShowMedicos();
                break;
                case 2: Utility.clearTerminal();
                        System.out.println("[+] Listado de especialidades de medicos");
                        System.out.println();
                        caHorario.caShowEspecialidad();
                    break;
                case 3:
                        caHorario.caShowHorario();
                    
                    break;
                case 4:
                        caHorario.caBuscar();
                    
                    break;
                    case 0: 
                            System.out.println("Vuelva pronto "+ caUsuario.toUpperCase());
                            System.exit(caMenuInicial);
                    break;
            
                default:
                    break;
            }
        } while (caMenuInicial != 6);
        scanner.close();
        
    }
}
