TROUBLESHOOTING:

JAVA_HOME doesn't exist:
Set JAVA_HOME Environment Variable:

Right-click on 'This PC' or 'My Computer' on your desktop or in File Explorer.
Click on 'Properties'.
Click on 'Advanced system settings'.
In the System Properties window, go to the 'Advanced' tab and click on 'Environment Variables...'.
In the Environment Variables window, under 'System variables', click 'New...'.
For 'Variable name', enter JAVA_HOME.
For 'Variable value', enter the path to your JDK installation (e.g., C:\Program Files\Java\jdk-17.0.10).
Click OK.
Update the System Path:

In the same 'Environment Variables' window, under 'System variables', scroll to find the 'Path' variable and select it.
Click 'Edit...'.
In the 'Edit environment variable' window, click 'New' and add %JAVA_HOME%\bin.
Click OK in all open windows to close them.