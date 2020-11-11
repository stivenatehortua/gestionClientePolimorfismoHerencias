package com.tcs.taller.clientes;

import com.tcs.taller.clases.Clientes;
import com.tcs.taller.clases.Empresas;
import com.tcs.taller.clases.Personas;
import com.tcs.taller.clases.Producto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.tcs.taller.clientes.constantes.Constantes.*;

public class Main {

    static ArrayList<Clientes> clientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer opMenu;
        Integer opMenuCase1;
        Integer opMenuCase2;
        Integer opMenuCase3;
        Integer opMenuCase4;
        Integer opMenuCase5;
        Integer posicion;
        String tipoCliente;
        boolean actualizacion = false;

        System.out.println("\n\t\t\t\t\t\t¡¡¡¡¡¡¡¡¡BIENVENIDO!!!!!!!!!");
        do {
            System.out.println("-------------------------------------||-------------------------------------\n" +
                    "\t\t1. Agregar cliente\n" +
                    "\t\t2. Editar cliente\n" +
                    "\t\t3. Eliminar cliente\n" +
                    "\t\t4. Agregar productos\n" +
                    "\t\t5. Consultar clientes con documento y tipo de documento \n" +
                    "\t\t0. salir de la aplicacion \n" +
                    "-------------------------------------||-------------------------------------");
            opMenu = scanner.nextInt();
            switch (opMenu) {
                case 1:
                    do {
                        System.out.println("Ingrese tipo de cliente:\n" +
                                "1. Empresarial \n" +
                                "2. Persona Natural \n" +
                                "0. Atras");
                        opMenuCase1 = scanner.nextInt();
                        switch (opMenuCase1) {
                            case 1:
                                clientes.add(agregarClienteEmpresarial());
                                opMenuCase1 = validarOpcion(MSG_AGREGAR_OTRO_CLIENTE);
                                break;
                            case 2:
                                clientes.add(agregarClientePersonaNatural());
                                opMenuCase1 = validarOpcion(MSG_AGREGAR_OTRO_CLIENTE);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Ingrese un valor valido del menú.");
                                break;
                        }
                    } while (!opMenuCase1.equals(0));
                    break;
                case 2:
                    do {
                        if (!clientes.isEmpty()) {
                            posicion = buscaCliente(obtenerRespuesta(MSG_TIPO_DOCUMENTO_BUSCAR),
                                    obtenerRespuestaNumerica(MSG_DOCUMENTO_BUSCAR));

                            if (posicion != -1) {
                                tipoCliente = obtenerTipoDeCliente(clientes.get(posicion));
                                if (tipoCliente.equals(PERSONAL)) {
                                    actualizacion = actualizarClientePersonaNatural(posicion);
                                } else if (tipoCliente.equals(EMPRESARIAL)) {
                                    actualizacion = actualizarClienteEmpresarial(posicion);
                                }
                                if (actualizacion) {
                                    opMenuCase2 = validarOpcion("Desea editar otro cliente? (SI/NO):");
                                } else {
                                    opMenuCase2 = 0;
                                }
                            } else {
                                System.out.println(MSG_CLIENTE_NO_ENCONTRADO);
                                opMenuCase2 = validarOpcion(MSG_NUEVA_BUSQUEDA);
                            }
                        } else {
                            System.out.println(MSG_NO_HAY_DATOS);
                            opMenuCase2 = 0;
                        }

                    } while (opMenuCase2 != 0);
                    break;
                case 3:
                    do {
                        if (!clientes.isEmpty()) {
                            posicion = buscaCliente(obtenerRespuesta(MSG_TIPO_DOCUMENTO_BUSCAR),
                                    obtenerRespuestaNumerica(MSG_DOCUMENTO_BUSCAR));

                            if (posicion != -1) {
                                confirmarEliminacion(posicion);
                                opMenuCase3 = validarOpcion("Desea eliminar otro cliente? (SI/NO):");
                            } else {
                                System.out.println(MSG_CLIENTE_NO_ENCONTRADO);
                                opMenuCase3 = validarOpcion(MSG_NUEVA_BUSQUEDA);
                            }
                        } else {
                            System.out.println(MSG_NO_HAY_DATOS);
                            opMenuCase3 = 0;
                        }
                    } while (opMenuCase3 != 0);
                    break;
                case 4:
                    do {
                        if (!clientes.isEmpty()) {
                            posicion = buscaCliente(obtenerRespuesta(MSG_TIPO_DOCUMENTO_BUSCAR),
                                    obtenerRespuestaNumerica(MSG_DOCUMENTO_BUSCAR));

                            if (posicion != -1) {
                                System.out.println("Cliente seleccionado\n" + clientes.get(posicion).toString());
                                actualizacion = asociarProductos(posicion);
                                if (actualizacion) {
                                    opMenuCase4 = validarOpcion(
                                            "Desea agregar un producto a otro cliente? (SI/NO):");
                                } else {
                                    opMenuCase4 = 0;
                                }
                            } else {
                                System.out.println(MSG_CLIENTE_NO_ENCONTRADO);
                                opMenuCase4 = validarOpcion(MSG_NUEVA_BUSQUEDA);
                            }
                        } else {
                            System.out.println(MSG_NO_HAY_DATOS);
                            opMenuCase4 = 0;
                        }
                    } while (opMenuCase4 != 0);
                    break;
                case 5:
                    do {
                        if (!clientes.isEmpty()) {
                            posicion = buscaCliente(obtenerRespuesta(MSG_TIPO_DOCUMENTO_BUSCAR),
                                    obtenerRespuestaNumerica(MSG_DOCUMENTO_BUSCAR));

                            if (posicion != -1) {
                                opMenuCase5 = validarOpcion("Desea consultar otro cliente? (SI/NO):");
                            } else {
                                System.out.println(MSG_CLIENTE_NO_ENCONTRADO);
                                opMenuCase5 = validarOpcion(MSG_NUEVA_BUSQUEDA);
                            }
                        } else {
                            System.out.println(MSG_NO_HAY_DATOS);
                            opMenuCase5 = 0;
                        }
                    } while (opMenuCase5 != 0);
                    break;
                case 0:
                    System.out.println("Vuelva pronto =).");
                    break;
                default:
                    System.out.println("Por favor ingrse un valor mostrado en el menú.");
                    break;
            }
        } while (!opMenu.equals(0));
    }

    private static int validarOpcion(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        int opcion = 1;
        System.out.println(mensaje);
        respuesta = scanner.nextLine().toUpperCase();
        boolean control = true;
        while (control) {
            switch (respuesta) {
                case "SI":
                    control = false;
                    break;
                case "NO":
                    opcion = 0;
                    control = false;
                    break;
                default:
                    System.out.println("Ingrese un valor valido (SI/NO).");
                    System.out.println(mensaje);
                    respuesta = scanner.nextLine().toUpperCase();
                    break;
            }
        }
        return opcion;
    }

    private static String obtenerRespuesta(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    private static String obtenerRespuestaNumerica(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        String valor;
        boolean esNumerico;
        do {
            System.out.println(mensaje);
            valor = scanner.nextLine();
            esNumerico = isNumeric(valor);
            if (!esNumerico) {
                System.out.println("Ingrese un valor numerico entero.");
            }
        } while (!esNumerico);
        return valor;
    }

    private static String obtenerDocumento(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        String valor;
        boolean esNumerico;
        do {
            System.out.println(mensaje);
            valor = scanner.nextLine();
            esNumerico = isNumeric(valor);
            if (!esNumerico) {
                System.out.println("Ingrese un documento valido.");
            } else {
                for (Clientes cliente : clientes) {
                    if ((cliente instanceof Empresas && (((Empresas) cliente).getDocumento().equals(valor))) ||
                            (cliente instanceof Personas && (((Personas) cliente).getCedula().equals(valor)))) {
                        System.out.println(MSG_DOCUMENTO_REGISTRADO + "\n" + MSG_INGRESE_OTRO_DOCUMENTO);
                        valor = obtenerDocumento(mensaje);
                    }
                }
            }
        } while (!esNumerico);
        return valor;
    }

    private static boolean isNumeric(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private static Clientes agregarClienteEmpresarial() {
        Clientes empresa = new Empresas(obtenerRespuesta("Ingrese el nombre de la empresa:"),
                obtenerRespuestaNumerica("Ingrese el telefono de la empesa:"),
                obtenerRespuesta("Ingrese la dirección de la empresa:"),
                obtenerRespuesta("Ingrese el tipo documento:"),
                obtenerDocumento("Ingrese el número del documento de la empresa:"),
                obtenerRespuesta("Ingrese el representante de la empresa:"));
        System.out.println("Cliente empresaial creado satisfactoriamente!");
        System.out.println(empresa.toString());
        return empresa;
    }

    private static Clientes agregarClientePersonaNatural() {
        Clientes persona = new Personas(obtenerRespuesta("Ingrese el nombre:"),
                obtenerRespuestaNumerica("Ingrese el telefono:"),
                obtenerRespuesta("Ingrese la dirección:"),
                obtenerDocumento("Ingrese la cédula:"),
                obtenerRespuestaNumerica("Ingrese el número de celular:"));
        System.out.println("Cliente persona natural creado satisfactoriamente!");
        System.out.println(persona.toString());
        return persona;
    }

    private static String obtenerTipoDeCliente(Clientes cliente) {
        return cliente instanceof Personas ? PERSONAL : EMPRESARIAL;
    }

    private static int buscaCliente(String tipoDocumento, String numeroDocumento) {
        int posicion = -1;
        tipoDocumento = tipoDocumento.toUpperCase();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i) instanceof Empresas &&
                    (((Empresas) clientes.get(i)).getTipDocumento().toUpperCase()).equals(tipoDocumento) &&
                    (((Empresas) clientes.get(i)).getDocumento()).equals(numeroDocumento)) {
                System.out.println("Cliente encontrado:\n" + ((Empresas) clientes.get(i)).toString());
                posicion = i;

            } else if (clientes.get(i) instanceof Personas && (tipoDocumento.equals("CC") &&
                    ((Personas) clientes.get(i)).getCedula().equals(numeroDocumento))) {
                System.out.println("Cliente encontrado:\n" + ((Personas) clientes.get(i)).toString());
                posicion = i;
            }
        }
        return posicion;
    }

    private static boolean actualizarClientePersonaNatural(Integer posicion) {
        int opcion;
        boolean actualizacion = false;
        do {
            opcion = Integer.parseInt(obtenerRespuesta("Que campo desea actualizar: \n" +
                    "1. Actualizar nombre \n" +
                    "2. Actualizar teléfono \n" +
                    "3. Actualizar dirección \n" +
                    "4. Actualizar cédula \n" +
                    "5. Actualizar celular \n" +
                    "0. Atras"));
            switch (opcion) {
                case 1:
                    clientes.get(posicion).setNombre(obtenerRespuesta("Ingrese su nuevo nombre:"));
                    System.out.println(MSG_ACTUALIZACION_DATO_EXITOSO);
                    actualizacion = true;
                    break;
                case 2:
                    clientes.get(posicion).setTelefono(
                            obtenerRespuestaNumerica("Ingrese su nuevo teléfono:"));
                    System.out.println(MSG_ACTUALIZACION_DATO_EXITOSO);
                    actualizacion = true;
                    break;
                case 3:
                    clientes.get(posicion).setDireccion(obtenerRespuesta("Ingrese su nueva dirección:"));
                    System.out.println(MSG_ACTUALIZACION_DATO_EXITOSO);
                    actualizacion = true;
                    break;
                case 4:
                    ((Personas) clientes.get(posicion)).setCedula(
                            obtenerRespuestaNumerica("Ingrese su nueva cédula:"));
                    System.out.println(MSG_ACTUALIZACION_DATO_EXITOSO);
                    actualizacion = true;
                    break;
                case 5:
                    ((Personas) clientes.get(posicion)).setCelular(
                            obtenerRespuestaNumerica("Ingrese su nuevo celular:"));
                    System.out.println(MSG_ACTUALIZACION_DATO_EXITOSO);
                    actualizacion = true;
                    break;
                case 0:
                    if (actualizacion) {
                        System.out.println(MSG_CLIENTE_ACTUALIZADO_CORECTAMENTE);
                        System.out.println(((Personas) clientes.get(posicion)).toString());
                        actualizacion = false;
                    } else {
                        System.out.println(MSG_NO_ACTUALIZACION);
                        opcion = 0;
                    }
                    break;
                default:
                    System.out.println(MSG_OPCION_VALIDA);
                    break;
            }
        } while (opcion != 0);
        return actualizacion;
    }

    private static boolean actualizarClienteEmpresarial(Integer posicion) {
        int opcion;
        boolean actualizacion = false;
        do {
            opcion = Integer.parseInt(obtenerRespuesta("Que campo desea actualizar: \n" +
                    "1. Actualizar nombre \n" +
                    "2. Actualizar teléfono \n" +
                    "3. Actualizar dirección \n" +
                    "4. Actualizar tipo documento \n" +
                    "5. Actualizar documento \n" +
                    "6. Actualizar representante \n" +
                    "0. Atras"));
            switch (opcion) {
                case 1:
                    clientes.get(posicion).setNombre(obtenerRespuesta("Ingrese su nuevo nombre:"));
                    System.out.println(MSG_ACTUALIZACION_DATO_EXITOSO);
                    actualizacion = true;
                    break;
                case 2:
                    clientes.get(posicion).setTelefono(obtenerRespuestaNumerica("Ingrese su nuevo teléfono:"));
                    System.out.println(MSG_ACTUALIZACION_DATO_EXITOSO);
                    actualizacion = true;
                    break;
                case 3:
                    clientes.get(posicion).setDireccion(obtenerRespuesta("Ingrese su nueva dirección:"));
                    System.out.println(MSG_ACTUALIZACION_DATO_EXITOSO);
                    actualizacion = true;
                    break;
                case 4:
                    ((Empresas) clientes.get(posicion)).setTipDocumento(
                            obtenerRespuesta("Ingrese su nuevo tipo de documento:"));
                    System.out.println(MSG_ACTUALIZACION_DATO_EXITOSO);
                    actualizacion = true;
                    break;
                case 5:
                    ((Empresas) clientes.get(posicion)).setDocumento(
                            obtenerRespuestaNumerica("Ingrese su nuevo celular:"));
                    System.out.println(MSG_ACTUALIZACION_DATO_EXITOSO);
                    actualizacion = true;
                    break;
                case 6:
                    ((Empresas) clientes.get(posicion)).setRepresentante(
                            obtenerRespuesta("Ingrese su nuevo representante:"));
                    System.out.println(MSG_ACTUALIZACION_DATO_EXITOSO);
                    actualizacion = true;
                    break;
                case 0:
                    if (actualizacion) {
                        System.out.println(MSG_CLIENTE_ACTUALIZADO_CORECTAMENTE);
                        System.out.println(((Empresas) clientes.get(posicion)).toString());
                        actualizacion = false;
                    } else {
                        System.out.println(MSG_NO_ACTUALIZACION);
                        opcion = 0;
                    }
                    break;
                default:
                    System.out.println(MSG_OPCION_VALIDA);
                    break;
            }
        } while (opcion != 0);
        return actualizacion;
    }

    private static boolean asociarProductos(Integer posicion) {
        int aceptar;
        int opcion;
        boolean actualizacion = false;
        do {
            opcion = Integer.parseInt(obtenerRespuesta("Qué desea hacer: \n" +
                    "1. Agregar producto \n" +
                    "0. Atras"));
            switch (opcion) {
                case 1:
                    Producto producto = new Producto(obtenerRespuesta("Ingrese el nombre del producto:"),
                            obtenerRespuesta("Ingrese las caracteristicas del producto"),
                            obtenerRespuesta("Ingrese las condiciones del producto"));
                    aceptar = validarOpcion("Acepta agregar este producto (SI/NO):");
                    if (aceptar == 1) {
                        clientes.get(posicion).addProductos(producto);
                        System.out.println("Se agrego el producto correctamente!");
                        opcion = validarOpcion("Desea agregar otro producto? (SI/NO):");
                        actualizacion = true;
                    } else {
                        System.out.println("No se agrego el producto.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println(MSG_OPCION_VALIDA);
                    break;
            }
        } while (opcion != 0);

        if ((clientes.get(posicion) instanceof Empresas) && !(clientes.get(posicion).getProductos().isEmpty())) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t¡¡¡¡¡¡¡¡¡PRODUCTOS!!!!!!!!!\n" +
                    "\nNombre de la empresa: " + clientes.get(posicion).getNombre() +
                    "\t\tDocumento: " + ((Empresas) clientes.get(posicion)).getDocumento() +
                    "\t\tDirección: " + clientes.get(posicion).getDireccion() +
                    "\t\tTelefono: " + clientes.get(posicion).getTelefono() +
                    "\t\tRepresentante: " + ((Empresas) clientes.get(posicion)).getRepresentante() +
                    "\t\tCantidad de productos: " + clientes.get(posicion).getProductos().size());
            for (int i = 0; i < clientes.get(posicion).getProductos().size(); i++) {
                System.out.println(clientes.get(posicion).getProductos().get(i).toString());
            }
        } else if ((clientes.get(posicion) instanceof Personas) && !(clientes.get(posicion).getProductos().isEmpty())) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t¡¡¡¡¡¡¡¡¡PRODUCTOS!!!!!!!!!\n" +
                    "Nombre: " + clientes.get(posicion).getNombre() +
                    "\t\tDocumento: " + ((Personas) clientes.get(posicion)).getCedula() +
                    "\t\tDirección: " + clientes.get(posicion).getDireccion() +
                    "\t\tCelular: " + ((Personas) clientes.get(posicion)).getCelular() +
                    "\t\tCantidad de productos" + clientes.get(posicion).getProductos().size());
            for (int i = 0; i < clientes.get(posicion).getProductos().size(); i++) {
                System.out.println(clientes.get(posicion).getProductos().get(i).toString());
            }
        }
        return actualizacion;
    }

    private static void confirmarEliminacion(Integer posicion) {
        int confirmacion;
        confirmacion = validarOpcion("está seguro que desea eliminar el usuario "
                + clientes.get(posicion).getNombre() + "? (SI/NO)");
        if (confirmacion == 1) {
            clientes.remove(posicion.intValue());
            System.out.println("Cliente eliminado exitosamente!");
        } else {
            System.out.println("El usuario no fue eliminado.");
        }
    }
}