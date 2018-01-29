<blockquote>
    <H1><U>Toy Robot Project</U></H1>
 </blockquote>
 
<pre lang="terminal">
The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 x 5 units.
</pre>


<TABLE>
<TR><TD COLSPAN="2">This is a Robot !!</TD></TR>
<TR><TD>Version</TD><TD>1.0.0.X</TD></TR>
<TR><TD>Name</TD><TD>Akshay Zaveri</TD></TR>
<TR><TD>Model</TD><TD>T-900</TD></TR>
</TABLE>

<blockquote>
<H1><U>Artifacts</U></H1>
</blockquote>
<TABLE>
<TR><TD>Swagger Documentation</TD><TD>https://toy-robot-t900.herokuapp.com/toyRobot/swagger-ui.html</TD></TR>
<TR><TD>Live Implementation</TD><TD>https://toy-robot-t900.herokuapp.com/toyRobot/joyStick/report</TD></TR>
<TR><TD>Postman Collections</TD><TD>https://github.com/zaveriakshay/toyrobot/tree/develop/Postman</TD></TR>
<TR><TD>Source Code</TD><TD>https://github.com/zaveriakshay/toyrobot/tree/develop/src</TD></TR>
</TABLE>

<blockquote>
<H1><U>Instructions</U></H1>
</blockquote>
<DIV>
<P>
<UL>
    <LI><code><B><U>PLACE</U></B></code> will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.</LI>
    <LI><code><B><U>MOVE</U></B></code> will move the toy robot one unit forward in the direction it is currently facing.</LI>
    <LI><code><B><U>LEFT</U></B></code> and <code><B><U>RIGHT</U></B></code> will rotate the robot 90 degrees in the speciﬁed direction without changing the position of the robot.</LI>
    <LI><code><B><U>REPORT</U></B></code> will announce the X,Y and F of the robot.</LI>
</UL>
</P>
<DIV>

<blockquote>
<H1><U>Rules</U></H1>
</blockquote>
<DIV>
<P>
<UL>
    <LI>The origin (0,0) can be considered to be the SOUTH WEST most corner, this always the default posiion on the robot</LI>
    <LI>The robot must not fall off the table during movement. This also includes the initial placement of the toy robot.</LI>
    <LI>The robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT and REPORT commands.</LI>
</UL>
</P>
<DIV>
