/**
 * Copyright (c) 2006, 2007, 2008 Marwan Abi-Antoun, Jonathan Aldrich, Nels E. Beckman,
 * Kevin Bierhoff, David Dickey, Ciera Jaspan, Thomas LaToza, Gabriel Zenarosa, and others.
 *
 * This file is part of Crystal.
 *
 * Crystal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Crystal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Crystal.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.cmu.cs.crystal.tac;


import edu.cmu.cs.crystal.flow.IFlowAnalysisDefinition;

/**
 * Interface for defining flow analysis transfer functions based on 3-address code instructions.
 * Implement this interface directly or use one of the pre-defined abstract base classes
 * for it.  Use this interface for defining standard flow analyses; use
 * {@link ITACBranchSensitiveTransferFunction} for branch-sensitive flow analyses.
 * 
 * To create a flow analysis, pass an instance of this interface to
 * {@link BranchInsensitiveTACAnalysis}.
 * 
 * @author Kevin Bierhoff
 *
 * @param <LE> Type representing the analysis knowledge.
 * 
 * @see TACInstruction
 */
public interface ITACTransferFunction<LE> extends IFlowAnalysisDefinition<LE> {
	
	/**
	 * This method is used to pass a variable query interface to the
	 * transfer function.  Transfer functions can, but do not
	 * have to, store the passed object in one of their fields for future use.
	 * The provided object can be used to find {@link Variable} objects for AST nodes.  
	 * @param context Interface to query for variables given AST nodes.
	 */
	public void setAnalysisContext(ITACAnalysisContext context);
	
	public LE transfer(ArrayInitInstruction instr, LE value);

	public LE transfer(BinaryOperation binop, LE value);

	public LE transfer(CastInstruction instr, LE value);

	public LE transfer(DotClassInstruction instr, LE value);

	public LE transfer(ConstructorCallInstruction instr, LE value);

	public LE transfer(CopyInstruction instr, LE value);

	public LE transfer(EnhancedForConditionInstruction instr, LE value);

	public LE transfer(InstanceofInstruction instr, LE value);

	public LE transfer(LoadLiteralInstruction instr, LE value);

	public LE transfer(LoadArrayInstruction instr, LE value);

	public LE transfer(LoadFieldInstruction instr, LE value);

	public LE transfer(MethodCallInstruction instr, LE value);

	public LE transfer(NewArrayInstruction instr, LE value);

	public LE transfer(NewObjectInstruction instr, LE value);

	public LE transfer(ReturnInstruction instr, LE value);

	public LE transfer(StoreArrayInstruction instr, LE value);

	public LE transfer(StoreFieldInstruction instr, LE value);

	public LE transfer(SourceVariableDeclaration instr, LE value);
	
	public LE transfer(SourceVariableRead instr, LE value);
	
	public LE transfer(UnaryOperation unop, LE value);
	
}
