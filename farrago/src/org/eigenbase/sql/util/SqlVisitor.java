/*
// $Id$
// Package org.eigenbase is a class library of database components.
// Copyright (C) 2004-2004 Disruptive Tech
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
package org.eigenbase.sql.util;

import org.eigenbase.sql.*;

/**
 * Visitor class, follows the
 * {@link org.eigenbase.util.Glossary#VisitorPattern visitor pattern}.
 *
 * @see org.eigenbase.sql.util.SqlBasicVisitor
 *
 * @author jhyde
 * @version $Id$
 */
public interface SqlVisitor {
    void visit(SqlLiteral literal);
    void visit(SqlCall call);
    void visit(SqlNodeList nodeList);
    void visit(SqlIdentifier id);
    void visit(SqlDataType type);
    void visit(SqlDynamicParam param);
    void visit(SqlIntervalQualifier intervalQualifier);
}

// End SqlVisitor.java