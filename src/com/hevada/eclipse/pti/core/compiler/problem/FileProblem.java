/*******************************************************************************
 * Copyright (c) 2009, 2010 Sven Kiera
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.hevada.eclipse.pti.core.compiler.problem;

import org.eclipse.core.resources.IFile;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;

public class FileProblem extends DefaultProblem {

	protected IFile originatingFile;

	public FileProblem(IFile originatingFile, String message,
			IProblemIdentifier id, String[] stringArguments,
			ProblemSeverity severity, int startPosition, int endPosition,
			int line, int column) {
		super(originatingFile.getFullPath().toOSString(), message, id,
				stringArguments, severity, startPosition, endPosition, line,
				column);
		this.originatingFile = originatingFile;
	}

	public FileProblem(IFile originatingFile, String message,
			IProblemIdentifier id, String[] stringArguments,
			ProblemSeverity severity, int startPosition, int endPosition,
			int line) {
		this(originatingFile, message, id, stringArguments, severity,
				startPosition, endPosition, line, 0);
	}

	public void setOriginatingFile(IFile originatingFile) {
		this.originatingFile = originatingFile;
		setOriginatingFileName(originatingFile.getFullPath().toOSString());
	}

	public IFile getOriginatingFile() {
		return this.originatingFile;
	}
}
