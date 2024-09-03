To install Windows Subsystem for Linux (WSL) on Windows 10 or Windows 11, follow these steps:

### For Windows 11

1. **Open PowerShell as Administrator:**
   - Right-click the Start button and select **Windows Terminal (Admin)** or **PowerShell (Admin)**.

2. **Install WSL:**
   ```bash
   wsl --install
   ```
   This command will install WSL and the default Linux distribution.

3. **Restart Your Computer:**
   - You might need to restart your computer to complete the installation.

4. **Set Up Your Linux Distribution:**
   - After your computer restarts, open the Start menu, and search for the Linux distribution you installed (like Ubuntu).
   - Launch it and follow the on-screen instructions to complete the setup.

### For Windows 10

1. **Open PowerShell as Administrator:**
   - Right-click the Start button and select **Windows PowerShell (Admin)**.

2. **Enable the WSL Feature:**
   ```bash
   dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
   ```

3. **Enable the Virtual Machine Platform Feature:**
   ```bash
   dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
   ```

4. **Install the WSL 2 Kernel Update Package:**
   - Download the WSL 2 kernel update package from the [WSL 2 Kernel Update](https://aka.ms/wsl2kernel) page and run the installer.

5. **Set WSL 2 as Your Default Version:**
   ```bash
   wsl --set-default-version 2
   ```

6. **Install Your Preferred Linux Distribution:**
   - Open the Microsoft Store and search for the Linux distribution you want (e.g., Ubuntu, Debian, Fedora).
   - Click **Install**.

7. **Set Up Your Linux Distribution:**
   - After installation, launch the Linux distribution from the Start menu.
   - Follow the on-screen instructions to set up your user account.