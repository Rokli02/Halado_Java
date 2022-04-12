# ProcessFlow

Creating an application
- easy to extend
- at least 3 maven artifact
  - mainframe - console app (jar, excutable)
    - BaseRunner + main
    - can create more flows and the output of one flow will be the input of the next flow
    - one method is mandatory which runs the flow. Thsi method depends on BaseFlow only.
    - in the main the flow has to be created.
  - flow interface provider (jar) 
    - BaseFlow 
      - the flow can accept or deny the incoming data. 
      - mandatory fields 
        - setInput
        - getOutput
        - do
  - concrete implementation (jar)
    - implement BaseFlow (name - points pair)
    - csv -> xml
    - xml -> memory array 
    - memory array -> aggregated result
    - aggregated result -> xml
    - aggregated result -> csv

valid filter flows:

csv -> xml -> aggregated result -> memory array -> csv

xml -> aggregated result -> memory array -> csv

xml -> aggregated result -> memory array -> xml


dependencies

mainframe -> "flow interface provider"

mainframe -> "concrete implementation"

"concrete implementation" -> "flow interface provider"

notes

Any user can define his own implementation writing the conrete jar based on flow interface provider.

The proper version is annotation base (annotation definition in interface)
