import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Horario extends HorarioBase implements IGestiaArchivosHorario {
    public static Scanner sc = new Scanner(System.in);
    @Override
    public void caReadHorarioMedicos(String caDirectorioHorarios) {
        
    }

    @Override
    public void caShowEspecialidad()  {
        String caArchivo= ".\\src\\Horarioss";
        File caCarpeta = new File(caArchivo);
        File[] caFiles = caCarpeta.listFiles((caDirectorio,caNombre)->caNombre.endsWith(".csv"));

        if (caFiles != null) {
            for (File caFile : caFiles) {
                try (BufferedReader caRead = new BufferedReader(new FileReader(caFile))){
                    String caLinea;
                    while ((caLinea = caRead.readLine()) != null) {
                        HorarioFormato hf = new HorarioFormato();
                        String[] caDatos = caLinea.split(";");
                        hf.caCodigo     = caDatos[1];
                        hf.caMateria    = caDatos[2];
                        hf.caParelelo   = caDatos[3];
                        hf.caAula       = caDatos[4];
                        hf.caCreditos   = caDatos[5];
                        System.out.println("-"+hf.caCodigo+"-"+ hf.caParelelo+" "+hf.caMateria);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }

    }

    @Override
    public void caShowMedicos(){
        String caRutaCarpeta = ".\\src\\Horarioss";
        File caCarpeta = new File(caRutaCarpeta);
        if (caCarpeta.exists() && caCarpeta.isDirectory()) {
            File[] caArchivos = caCarpeta.listFiles();
            if (caArchivos != null) {
                for (File caFile : caArchivos) {
                    if (caFile.isFile()) {
                        String caNombreArchivo = caFile.getName();
                        String caAlumos = caNombreArchivo.substring(0,caNombreArchivo.length()-4);
                        System.out.println("-"+ caAlumos);
                    }
                }
                
            }
        }
    } 

    public void caShowHorario(){
        String caArchivo= ".\\src\\Horarioss";
        File caCarpeta = new File(caArchivo);
        File[] caFiles = caCarpeta.listFiles((caDirectorio,caNombre)->caNombre.endsWith(".csv"));

        if (caFiles != null) {
            for (File caFile : caFiles) {
                try (BufferedReader caRead = new BufferedReader(new FileReader(caFile))){
                    String caLinea;
                    System.out.println("Archivo: "+ caFile);
                    while (( caLinea = caRead.readLine()) != null) {
                        HorarioFormato hf = new HorarioFormato();
                        String[] caDatos = caLinea.split(";");
                        hf.caHoraLunes      = caDatos[6];
                        hf.caHoraMartes     = caDatos[7];
                        hf.caHoraMiercoles  = caDatos[8];
                        hf.caHoraJueves     = caDatos[9];
                        hf.caHoraViernes    = caDatos[10];
                        hf.caHoraSabado     = caDatos[11];
                        
                        System.out.println(hf.caHoraLunes+"\t"+ hf.caHoraMartes+"\t"+hf.caHoraMiercoles+"\t"+hf.caHoraJueves+"\t"+hf.caHoraViernes+"\t"+hf.caHoraSabado);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }
    
    public void caBuscar(){
        String caDirectorio = ".\\src\\Horarioss";
        System.out.print("[+] Ingresa el codigo a buscar: ");
        String caBuscar = sc.nextLine().trim();
        System.out.println(">>> Codigo: "+ caBuscar);
        File caCarpeta = new File(caDirectorio);
        File[] caFiles = caCarpeta.listFiles();
        if (caFiles != null) {
            for (File caFile : caFiles) {
                if (caFile.isFile() && caFile.getName().endsWith(".csv")) {
                    System.out.println("Archivo: "+ caFile.getName());
                    try (BufferedReader ca = new BufferedReader(new FileReader(caFile))){
                        String caLinea;
                        while (( caLinea = ca.readLine()) != null) {
                            if ( caLinea.contains(caBuscar)) {
                             caLinea = caLinea.replace(";", " ");
                                System.out.println (caLinea);
                            }
                        }
                        System.out.println();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            
        }

    }
    
}
