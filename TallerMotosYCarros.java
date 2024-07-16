import java.util.Scanner;

public class TallerMotosYCarros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        String[][][] trabajos = null;

        System.out.println("Bienvenido al administrador del taller.");

        do {
            System.out.println("Elija una opción para continuar: ");
            System.out.println("1. Para Asignar un vehiculo.");
            System.out.println("2. Para ver todos los vehículos.");
            System.out.println("3. Para buscar vehiculo.");
            System.out.println("4. Para Modificar vehiculo.");
            System.out.println("5. Para salir del programa.");
            int opciones = scanner.nextInt();
            scanner.nextLine();

            switch (opciones) {
                case 1:
                    System.out.print("Ingrese la capacidad del taller: ");
                    int maxEmployees = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el número de trabajos que desea registrar: ");
                    int numTrabajos = scanner.nextInt();
                    scanner.nextLine();


                    if (numTrabajos > maxEmployees) {
                        System.out.println("El número de trabajos no puede superar la capacidad del taller.");
                        continue;
                    }


                    trabajos = new String[maxEmployees][2][4];

                    for (int i = 0; i < numTrabajos; i++) {
                        System.out.print("Ingrese el nombre del empleado: ");
                        String nombreEmpleado = scanner.nextLine();

                        System.out.print("Ingrese el tipo de vehículo (0: Moto, 1: Carro): ");
                        int tipoVehiculo = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ingrese la marca: ");
                        String marca = scanner.nextLine();

                        System.out.print("Ingrese el modelo: ");
                        String modelo = scanner.nextLine();

                        System.out.print("Ingrese el año: ");
                        String año = scanner.nextLine();

                        System.out.print("Ingrese el estado (Pendiente, Reparado, Vendido): ");
                        String estado = scanner.nextLine();

                        trabajos[i][tipoVehiculo][0] = marca;
                        trabajos[i][tipoVehiculo][1] = modelo;
                        trabajos[i][tipoVehiculo][2] = año;
                        trabajos[i][tipoVehiculo][3] = estado;

                        System.out.println("Vehiculo registrado con exito.");
                    }
                    break;

                case 2:
                    if (trabajos == null) {
                        System.out.println("No hay trabajos registrados.");
                        break;
                    }

                    System.out.println("\nTabla de vehiculos:");
                    System.out.println("| Tipo | Marca | Modelo | Año | Estado |");
                    System.out.println("|------|-------|--------|-----|---------|");

                    for (int i = 0; i < trabajos.length; i++) {
                        for (int j = 0; j < 2; j++) {
                            if (trabajos[i][j][0] != null) {
                                String tipo = (j == 0) ? "Moto" : "Carro";
                                System.out.printf("| %s | %s | %s | %s | %s |\n", tipo, trabajos[i][j][0], trabajos[i][j][1], trabajos[i][j][2], trabajos[i][j][3]);
                            }
                        }
                    }

                    int pendientes = 0, vendidos = 0, reparados = 0;
                    for (int i = 0; i < trabajos.length; i++) {
                        for (int j = 0; j < 2; j++) {
                            if (trabajos[i][j][3] != null) {
                                switch (trabajos[i][j][3].toLowerCase()) {
                                    case "pendiente":
                                        pendientes++;
                                        break;
                                    case "vendido":
                                        vendidos++;
                                        break;
                                    case "reparado":
                                        reparados++;
                                        break;
                                }
                            }
                        }
                    }
                    System.out.println("\nResumen de estados:");
                    System.out.println("Pendientes: " + pendientes);
                    System.out.println("Reparados: " + reparados);
                    System.out.println("Vendidos: " + vendidos);
                    break;

                case 3:
                    if (trabajos == null) {
                        System.out.println("No hay trabajos registrados.");
                        break;
                    }

                    System.out.print("\nIngrese la marca del vehículo a buscar: ");
                    String marcaBuscar = scanner.nextLine();
                    System.out.print("Ingrese el modelo del vehículo a buscar: ");
                    String modeloBuscar = scanner.nextLine();

                    boolean encontrado = false;
                    for (int i = 0; i < trabajos.length; i++) {
                        for (int j = 0; j < 2; j++) {
                            if (trabajos[i][j][0] != null && trabajos[i][j][0].equalsIgnoreCase(marcaBuscar) && trabajos[i][j][1].equalsIgnoreCase(modeloBuscar)) {
                                String tipo = (j == 0) ? "Moto" : "Carro";
                                System.out.printf("Vehículo encontrado: | %s | %s | %s | %s | %s |\n", tipo, trabajos[i][j][0], trabajos[i][j][1], trabajos[i][j][2], trabajos[i][j][3]);
                                encontrado = true;
                            }
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 4:
                    if (trabajos == null) {
                        System.out.println("No hay trabajos registrados.");
                        break;
                    }

                    System.out.print("\nIngrese la marca del vehículo que desea actualizar: ");
                    marcaBuscar = scanner.nextLine();
                    System.out.print("Ingrese el modelo del vehículo que desea  actualizar: ");
                    modeloBuscar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo estado (Pendiente, Reparado, Vendido): ");
                    String nuevoEstado = scanner.nextLine();

                    encontrado = false;
                    for (int i = 0; i < trabajos.length; i++) {
                        for (int j = 0; j < 2; j++) {
                            if (trabajos[i][j][0] != null && trabajos[i][j][0].equalsIgnoreCase(marcaBuscar) && trabajos[i][j][1].equalsIgnoreCase(modeloBuscar)) {
                                trabajos[i][j][3] = nuevoEstado;
                                System.out.printf("Estado actualizado: | %s | %s | %s | %s | %s |\n", (j == 0) ? "Moto" : "Carro", trabajos[i][j][0], trabajos[i][j][1], trabajos[i][j][2], trabajos[i][j][3]);
                                encontrado = true;
                            }
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Vehículo no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Hasta pronto.");
                    salir = true;
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (!salir);

        scanner.close();
    }
}
