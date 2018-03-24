
#nameNode=hdfs://sandbox.hortonworks.com:8020
nameNode=hdfs://nn01.iwinner.com:8020
#jobTracker=sandbox.hortonworks.com:8050
jobTracker=rm01.iwinner.com:8050
queueName=default
user.name=anjaiahspr
#examplesRoot=oozie
oozie.wf.application.path=${nameNode}/user/${user.name}/apps/shell


Steps :
#Start OOZIE JOB::==>

oozie job -oozie http://nn01.iwinner.com:11000/oozie/ -config job.properties -run

OOZIE URL ===> http://nn01.iwinner.com:11000/oozie/

My Jobs INfo ===> http://nn01.iwinner.com:11000/oozie/?user.name=anjaiahspr

Checking the Status of a Workflow, Coordinator or Bundle Job or a Coordinator Action
Example:

Job Status :oozie job -oozie http://nn01.iwinner.com:11000/oozie/ -info 0000351-170330051735289-oozie-oozi-W

oozie job -oozie http://localhost:8080/oozie -log 14-20090525161321-oozie-joe


oozie job -oozie http://nn01.iwinner.com:11000/oozie/ -log 0000350-170330051735289-oozie-oozi-W

oozie job -oozie http://nn01.iwinner.com:11000/oozie/ -log 0000351-170330051735289-oozie-oozi-W
Example:
Validating a Workflow XML
$ oozie validate myApp/workflow.xml


 oozie validate <OPTIONS> <ARGS> : validate a workflow, coordinator, bundle XML file
                     -auth <arg>    select authentication type [SIMPLE|KERBEROS]
                     -oozie <arg>   Oozie URL
oozie validate workflow.xml -auth SIMPLE -oozie http://nn01.iwinner.com:11000/oozie/  
