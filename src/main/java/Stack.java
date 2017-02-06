/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hamzalaroussi
 */
public class Stack<T> 
{   
    private T[] data = null;
    private int top = 0;
    
    
     public Stack()
    {
        data = (T[]) new Object[10];
    }
    
    public boolean isOperator(String str)
    {
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }

    public boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c))
            {
                return false;
            }
        }
        return true;
    }
    
    public void push(T element)
    {
        data[top++] = element;
    }
    @Override
    public String toString()
    {
        String result = "";
        for (int i = 0; i < top; i++)
        {
            result += data[i] +" ";
        }
        return result;
    }
    public void calculate()
    {
        
        if (top>=3)
        {
            if (isOperator(data[top-1].toString()))
            {
                if (isNumeric(data[top-3].toString()) && isNumeric(data[top-2].toString()))
                {
                    if (data[top-1].equals("+"))
                    {
                        Integer result = Integer.parseInt(data[top-3].toString()) + Integer.parseInt(data[top-2].toString());
                        top = top-3;
                        push((T) result);
                    }
                    
                }
            }
            
        }
    
    }
}
