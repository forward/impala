// Copyright 2012 Cloudera Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.cloudera.impala.analysis;

import com.cloudera.impala.common.AnalysisException;
import com.cloudera.impala.common.InternalException;

/**
 * Representation of a SHOW DATABASES [pattern] statement. 
 * Acceptable syntax:
 *
 * SHOW DATABASES
 * SHOW SCHEMAS
 * SHOW DATABASES LIKE 'pattern'
 * SHOW SCHEMAS LIKE 'pattern'
 *
 */
public class ShowDbsStmt extends ParseNodeBase {
  // Pattern to match tables against. | denotes choice, * matches all strings
  private final String pattern;

  /**
   * Default constructor, which creates a show statement which returns all
   * databases.
   */
  public ShowDbsStmt() {
    this(null);
  }

  /**
   * Constructs a show statement which matches all databases against the
   * supplied pattern.
   */
  public ShowDbsStmt(String pattern) {
    this.pattern = pattern;
  }

  public String getPattern() {
    return pattern;
  }

  public String toSql() {
    if (pattern == null) {
        return "SHOW DATABASES";
    } else {
        return "SHOW DATABASES LIKE '" + pattern + "'";
    }
  }

  public String debugString() {
    return toSql();
  }

  public void analyze(Analyzer analyzer) throws AnalysisException, InternalException {
    // Nothing to do here
  }
}
