import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura= new Scanner(System.in);
        ConsultadorDeMoneda consulta=new ConsultadorDeMoneda();

      String monedaBase ="";
      String monedaAConvertir="";
      double cantidad =0;

        try{
            int opcion ;
            do{
                String menu= "Elije que quieres realizar:\n" +
                        "   Elije 1 para: Convertir Peso Mexicano a Dolar\n" +
                        "   Elije 2 para: Convertir Dolar a Peso Mexiado\n" +
                        "   Elije 3 para: Convertir Peso Mexicano a Euro\n" +
                        "   Elije 4 para: Convertir Euro a Peso Mexicano\n" +
                        "   Elije 5 para: Convertir Dolar a Euro\n" +
                        "   Elije 6 para: Convertir Euro a Dolar\n" +
                        "   Elije 7 para: Salir";
                System.out.println(menu);

                System.out.println("Opcion elegida:");
                opcion=lectura.nextInt();

                switch (opcion){
                    case 1:
                        System.out.println("Cantidad en peso Mexicano: ");
                        cantidad=lectura.nextDouble();
                        monedaBase="MXN";
                        monedaAConvertir="USD";

                        break;
                    case 2:
                        System.out.println("Cantidad en dolares: ");
                        cantidad=lectura.nextDouble();
                        monedaBase="USD";
                        monedaAConvertir="MXN";
                        break;
                    case 3:
                        System.out.println("Cantidad en peso Mexicano: ");
                        cantidad=lectura.nextDouble();
                        monedaBase="MXN";
                        monedaAConvertir="EUR";
                        break;
                    case 4:
                        System.out.println("Cantidad en Euro: ");
                        cantidad=lectura.nextDouble();
                        monedaBase="EUR";
                        monedaAConvertir="MXN";
                        break;
                    case 5:
                        System.out.println("Cantidad en Dolar: ");
                        cantidad=lectura.nextDouble();
                        monedaBase="USD";
                        monedaAConvertir="EUR";
                        break;
                    case 6:
                        System.out.println("Cantidad en Euro: ");
                        cantidad=lectura.nextDouble();
                        monedaBase="EUR";
                        monedaAConvertir="USD";
                        break;
                    case 7:
                        System.out.println("Gracias Vuelva pronto...");
                        System.exit(0);
                        break;


                }
                Valor consultadorDeMoneda = consulta.convertidorDeValor(monedaBase, monedaAConvertir, cantidad);
                System.out.println("El cantidad convertida es: "+ consultadorDeMoneda.conversion_result());
                System.out.println("************************************************");
            }
            while (opcion!=7);

        }catch (NumberFormatException e){
            System.out.println("Moneda no encontrada "+ e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación");
        }

    }
}