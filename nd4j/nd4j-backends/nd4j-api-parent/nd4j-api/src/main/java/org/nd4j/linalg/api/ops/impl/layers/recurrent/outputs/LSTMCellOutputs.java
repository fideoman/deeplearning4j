package org.nd4j.linalg.api.ops.impl.layers.recurrent.outputs;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import org.nd4j.autodiff.samediff.SDVariable;
import org.nd4j.base.Preconditions;
import org.nd4j.linalg.api.ops.impl.layers.recurrent.LSTMBlockCell;

/**
 * The outputs of a LSTM cell ({@link LSTMBlockCell}.
 */
@Getter
public class LSTMCellOutputs {

    /**
     * Output - input modulation gate activations [batchSize, numUnits].
     */
    private SDVariable i;

    /**
     * Activations, cell state (pre tanh) [batchSize, numUnits].
     */
    private SDVariable c;

    /**
     * Output - forget gate activations [batchSize, numUnits].
     */
    private SDVariable f;

    /**
     * Output - output gate activations [batchSize, numUnits].
     */
    private SDVariable o;

    /**
     * Output - input gate activations [batchSize, numUnits].
     */
    private SDVariable z;

    /**
     * Cell state, post tanh [batchSize, numUnits].
     */
    private SDVariable h;

    /**
     * Current cell output [batchSize, numUnits].
     */
    private SDVariable y;

    public LSTMCellOutputs(SDVariable[] outputs){
        Preconditions.checkArgument(outputs.length == 7,
                "Must have 7 LSTM cell outputs, got %s", outputs.length);

        i = outputs[0];
        c = outputs[1];
        f = outputs[2];
        o = outputs[3];
        z = outputs[4];
        h = outputs[5];
        y = outputs[6];
    }

    /**
     * Get all outputs returned by the cell.
     */
    public List<SDVariable> getAllOutputs(){
        return Arrays.asList(i, c, f, o, z, h, y);
    }

    /**
     * Get y, the output of the cell.
     *
     * Has shape [batchSize, numUnits].
     */
    public SDVariable getOutput(){
        return y;
    }

    /**
     * Get c, the cell's state.
     *
     * Has shape [batchSize, numUnits].
     */
    public SDVariable getState(){
        return c;
    }
}
