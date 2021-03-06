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
package org.eigenbase.rel.metadata;

/**
 * DefaultRelMetadataProvider supplies a default implementation of the {@link
 * RelMetadataProvider} interface. It provides generic formulas and derivation
 * rules for the standard logical algebra; coverage corresponds to the methods
 * declared in {@link RelMetadataQuery}.
 *
 * @author John V. Sichi
 * @version $Id$
 */
public class DefaultRelMetadataProvider
    extends ChainedRelMetadataProvider
{
    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new default provider. This provider defines "catch-all"
     * handlers for generic RelNodes, so it should always be given lowest
     * priority when chaining.
     */
    public DefaultRelMetadataProvider()
    {
        addProvider(new RelMdPercentageOriginalRows());

        addProvider(new RelMdColumnOrigins());

        addProvider(new RelMdRowCount());

        addProvider(new RelMdUniqueKeys());

        addProvider(new RelMdColumnUniqueness());

        addProvider(new RelMdPopulationSize());

        addProvider(new RelMdDistinctRowCount());

        addProvider(new RelMdSelectivity());
    }
}

// End DefaultRelMetadataProvider.java
