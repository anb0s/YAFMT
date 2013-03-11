/**
 */
package cz.jpikl.yafmt.clang.scl.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import cz.jpikl.yafmt.clang.scl.model.Expression;
import cz.jpikl.yafmt.clang.scl.model.ModelPackage;
import cz.jpikl.yafmt.model.fc.FeatureConfiguration;
import cz.jpikl.yafmt.model.fc.Selection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ExpressionImpl extends MinimalEObjectImpl.Container implements Expression {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExpressionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.EXPRESSION;
    }
    
    public List<Selection> getSelections(FeatureConfiguration featureConfig, Selection context, String id) {
        List<Selection> allSelections = featureConfig.getSelectionsById(id);
        if(allSelections == null)
            return Collections.emptyList();
        if((context == null) || (context == featureConfig.getRoot()))
            return allSelections;
        
        List<Selection> contextualSelections = new ArrayList<Selection>(allSelections.size());
        for(Selection selection: allSelections) {
            for(Selection ancestor = selection; ancestor != null; ancestor = ancestor.getParent()) {
                if(ancestor == context)
                    contextualSelections.add(selection);
            }
        }
        return contextualSelections;
    }
    

} //ExpressionImpl
