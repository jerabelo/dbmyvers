/*
// Licensed to DynamoBI Corporation (DynamoBI) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  DynamoBI licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
*/
package org.eigenbase.rel;

import org.eigenbase.relopt.*;
import org.eigenbase.rex.*;


/**
 * A <code>FilterRel</code> is a relational expression which iterates over its
 * input, and returns elements for which <code>condition</code> evaluates to
 * <code>true</code>.
 */
public final class FilterRel
    extends FilterRelBase
{
    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a filter.
     *
     * @param cluster {@link RelOptCluster}  this relational expression belongs
     * to
     * @param child input relational expression
     * @param condition boolean expression which determines whether a row is
     * allowed to pass
     */
    public FilterRel(
        RelOptCluster cluster,
        RelNode child,
        RexNode condition)
    {
        super(
            cluster,
            new RelTraitSet(CallingConvention.NONE),
            child,
            condition);
    }

    //~ Methods ----------------------------------------------------------------

    public FilterRel clone()
    {
        FilterRel clone =
            new FilterRel(
                getCluster(),
                getChild().clone(),
                getCondition().clone());
        clone.inheritTraitsFrom(this);
        return clone;
    }
}

// End FilterRel.java
