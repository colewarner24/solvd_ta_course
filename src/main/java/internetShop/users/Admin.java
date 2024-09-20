package internetShop.users;

import internetShop.exceptions.InvalidCredentialException;
import internetShop.exceptions.InvalidUserException;
import internetShop.payments.Payment;
import internetShop.utility.IDManager;
import internetShop.products.Product;

import java.lang.reflect.*;
import java.util.Base64;

// Final class to prevent inheritance and secure the Admin class
public final class Admin extends User implements AutoCloseable {
    private String credentials;
    private static String encodedKey;

    static {
        String passkey = "admin";
        encodedKey = Base64.getEncoder().encodeToString(passkey.getBytes());
    }

    public Admin(String name, String email, String credentials) throws InvalidUserException {
        super(name, email);
        if (credentials == null || credentials.isEmpty()) {
            throw new InvalidUserException("Invalid admin credentials");
        }
        this.credentials = credentials;
    }

    public Admin(int id, String name, String email, String credentials) throws InvalidUserException {
        super(id, name, email);
        if (credentials == null || credentials.isEmpty()) {
            throw new InvalidUserException("Invalid admin credentials");
        }
        this.credentials = credentials;
    }

    public boolean verifyCredentials() throws InvalidCredentialException {
        if (!Base64.getEncoder().encodeToString(credentials.getBytes()).equals(encodedKey)){
            throw new InvalidCredentialException("Invalid admin credentials");
        }
        return true;
    }

    public void reflectPaymentClass(){
        Class<?> reflectClass = Payment.class;

        System.out.println("Fields:");
        Field[] fields = reflectClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Name: " + field.getName());
            System.out.println("Type: " + field.getType());
            System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
            System.out.println();
        }
        System.out.println();

        System.out.println("Methods:");
        Method[] methods = reflectClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
            System.out.println("Return Type: " + method.getReturnType());
            System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
            System.out.println("Parameter Types: ");
            Class<?>[] paramTypes = method.getParameterTypes();
            for (Class<?> paramType : paramTypes) {
                System.out.println(paramType.getName());
            }
            System.out.println();
        }

        System.out.println("Constructors:");
        Constructor<?>[] constructors = reflectClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor.getName());
            System.out.println("Parameter Types: ");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> paramType : parameterTypes) {
                System.out.println(paramType.getName());
            }
            System.out.println();
        }

        try{
            Class<?> paymentClass = Class.forName("internetShop.payments.Payment");
            Method getId = paymentClass.getMethod("getId");

            Constructor<?> paymentConstructor = paymentClass.getConstructor();
            Object paymentInstance = paymentConstructor.newInstance();

            Method getIdMethod = paymentClass.getMethod("getId");
            int paymentId = (int) getIdMethod.invoke(paymentInstance);
            System.out.println("Payment id: " + paymentId);

        }
        catch (ClassNotFoundException e){
            System.out.println("payment class not found" + e);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void close() throws Exception {
        credentials = null;
        encodedKey = null;
    }
}