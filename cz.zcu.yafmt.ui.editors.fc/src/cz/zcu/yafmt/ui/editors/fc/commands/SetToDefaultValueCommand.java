package cz.zcu.yafmt.ui.editors.fc.commands;

import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.BOOLEAN_VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.DOUBLE_VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.INTEGER_VALUE;
import static cz.zcu.yafmt.model.fc.FeatureConfigurationPackage.STRING_VALUE;

import cz.zcu.yafmt.model.fc.AttributeValue;
import cz.zcu.yafmt.model.fc.BooleanValue;
import cz.zcu.yafmt.model.fc.DoubleValue;
import cz.zcu.yafmt.model.fc.IntegerValue;
import cz.zcu.yafmt.model.fc.StringValue;
import cz.zcu.yafmt.ui.commands.RecordingCommand;

public class SetToDefaultValueCommand extends RecordingCommand {

    private AttributeValue attributeValue;
    private Object newValue;

    public SetToDefaultValueCommand(AttributeValue attributeValue, Object newValue) {
        this.attributeValue = attributeValue;
        this.newValue = newValue;
        setLabel("Set To Default Value");
    }

    @Override
    public boolean canExecute() {
        try {
            switch(attributeValue.eClass().getClassifierID()) {
                case BOOLEAN_VALUE:
                    if (newValue instanceof String) {
                        String boolValStr = (String) newValue;
                        if ((boolValStr.toLowerCase().equals("true") || boolValStr.toLowerCase().equals("false"))) {
                            return true;
                        }
                        return false;
                    } else if (newValue instanceof Boolean) {
                        return true;
                    } else {
                        return false;
                    }
                case INTEGER_VALUE:
                    Integer.parseInt((String) newValue);
                    return true;
                case DOUBLE_VALUE:
                    Double.parseDouble((String) newValue);
                    return true;
                default:
                    return true;
            }
        }
        catch(NumberFormatException ex) {
            return false;
        }
    }

    @Override
    protected void initializeRecording() {
        addRecordedObject(attributeValue);
    }

    @Override
    protected void performRecording() {
        setLabel("Set " + attributeValue.getName() + " to " + newValue.toString());
        switch(attributeValue.eClass().getClassifierID()) {
            case BOOLEAN_VALUE:
                if (newValue instanceof String) {
                    ((BooleanValue) attributeValue).setValue(Boolean.parseBoolean((String) newValue));
                } else if (newValue instanceof Boolean) {
                    ((BooleanValue) attributeValue).setValue((Boolean) newValue);
                }
                break;
            case INTEGER_VALUE:
                ((IntegerValue) attributeValue).setValue(Integer.parseInt((String) newValue));
                break;
            case DOUBLE_VALUE:
                ((DoubleValue) attributeValue).setValue(Double.parseDouble((String) newValue));
                break;
            case STRING_VALUE:
                ((StringValue) attributeValue).setValue((String) newValue);
                break;
        }
    }

}
