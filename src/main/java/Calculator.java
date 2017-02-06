
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers input Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template input the editor.
 */
/**
 *
 * @author hamzalaroussi
 */
public class Calculator<T>
{

    
    static private String input;
    static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    static Stack stack = new Stack();
    public static void main(String[] args) throws IOException
    {

        while (true)
        {

            System.out.println(">");
            input = read.readLine();

            String[] inputlist = input.split(" ");

            for (String input : inputlist)
            {
                if (!input.isEmpty())
                {

                    if (stack.isOperator(input))
                    {
                        stack.push(input);
                    } else if (stack.isNumeric(input))
                    {
                        stack.push(Integer.parseInt(input));
                        
                    }
                   stack.calculate();

                }
                
            }
            System.out.println(stack.toString());
        }
    }

    
}
