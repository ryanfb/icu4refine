package io.github.ryanfb.icu4refine;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONWriter;

import com.google.refine.expr.EvalError;
import com.google.refine.grel.ControlFunctionRegistry;
import com.google.refine.grel.Function;

import com.ibm.icu.text.Transliterator;

public class Transliterate implements Function {

    public Object call(Properties bindings, Object[] args) {
        if(args.length==2){
            String transform = args[0].toString();
            String input = args[1].toString();
            Transliterator transliterator = null;
            
            try {
                transliterator = Transliterator.getInstance(transform);
            }
            catch (java.lang.IllegalArgumentException e) {
                return new EvalError(ControlFunctionRegistry.getFunctionName(this) + " transform string error: " + e.getMessage());
            }
            return transliterator.transliterate(input);
        }
        return new EvalError(ControlFunctionRegistry.getFunctionName(this) + " expects 2 strings");
    }

    public void write(JSONWriter writer, Properties options)
            throws JSONException {
        writer.object();
        writer.key("description"); writer.value("transliterates input string according to ICU transform");
        writer.key("params"); writer.value("string transform, string input");
        writer.key("returns"); writer.value("string");
        writer.endObject();
    }

}
