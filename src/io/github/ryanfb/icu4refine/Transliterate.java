package io.github.ryanfb.icu4refine;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONWriter;

import com.google.refine.expr.EvalError;
import com.google.refine.grel.ControlFunctionRegistry;
import com.google.refine.grel.Function;

public class Transliterate implements Function {

    public Object call(Properties bindings, Object[] args) {
        if(args.length==2){
            String transform = args[0].toString();
            String input = args[1].toString();
            if(input.isEmpty()){
            	return new EvalError(ControlFunctionRegistry.getFunctionName(this) + " Cannot transliterate empty string");
            }
            return input;
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
