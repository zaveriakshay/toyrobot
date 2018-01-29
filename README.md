<blockquote>
    <H1><U>Toy Robot Project</U></H1>
 </blockquote>
 
<pre lang="terminal">
The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 x 5 units.
</pre>


<TABLE>
<TR><TD>Version</TD><TD>1.0.0.X</TD></TR>
<TR><TD>Name</TD><TD>Akshay Zaveri</TD></TR>
<TR><TD>Model</TD><TD>T-900</TD></TR>
</TABLE>

<blockquote>
<H1><U>Artifacts</U></H1>
</blockquote>
<TABLE>
<TR><TD><B>Swagger Documentation<B/></TD><TD>https://toy-robot-t900.herokuapp.com/toyRobot/swagger-ui.html</TD></TR>
<TR><TD colspan="2"><img src="https://raw.githubusercontent.com/zaveriakshay/toyrobot/develop/Postman/swagger.jpg"/></TD></TR>
<TR><TD><B>Live Implementation</B></TD><TD>https://toy-robot-t900.herokuapp.com/toyRobot/joyStick/report</TD></TR>
<TR><TD><B>Postman Collections</B></TD><TD>https://github.com/zaveriakshay/toyrobot/tree/develop/Postman</TD></TR>
<TR><TD><B>Source Code</B></TD><TD>https://github.com/zaveriakshay/toyrobot/tree/develop/src</TD></TR>
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
    <LI>Currently there is no command to remove the robot off the table, we need to restart the spring boot application.</LI>
</UL>
</P>
<DIV>
    
<blockquote>
<H1><U>Technical Specifications</U></H1>
</blockquote>
<DIV>
<P>
<UL>
    <LI>This is a Spring Boot application</LI>
    <LI>Default port for this application is <code>8085</code>.</LI>
    <LI>Default context path for this application is <code>toyRobot</code></LI>
    <LI>Default controller for this application is <code>joyStick</code></LI>
    <LI>All services are REST, after the end point <code>/toyRobot/joyStick</code> are described on the swagger page as well
        <OL>
            <LI><CODE>PLACE</CODE> (POST) /toyRobot/joyStick/place</LI> 
            <LI><CODE>MOVE</CODE> (PUT) /toyRobot/joyStick/move</LI> 
            <LI><CODE>LEFT</CODE> (PUT) /toyRobot/joyStick/left</LI> 
            <LI><CODE>RIGHT</CODE> (PUT) /toyRobot/joyStick/right</LI>
            <LI><CODE>REPORT</CODE> (GET) /toyRobot/joyStick/report</LI> 
        </OL>
    </LI>
</UL>
</P>
<DIV>
