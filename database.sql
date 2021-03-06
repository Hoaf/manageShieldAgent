USE [master]
GO
/****** Object:  Database [shield1]    Script Date: 4/14/2019 11:14:22 PM ******/
CREATE DATABASE [shield1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'shield1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\shield1.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'shield1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\shield1_log.ldf' , SIZE = 3456KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [shield1] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [shield1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [shield1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [shield1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [shield1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [shield1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [shield1] SET ARITHABORT OFF 
GO
ALTER DATABASE [shield1] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [shield1] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [shield1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [shield1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [shield1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [shield1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [shield1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [shield1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [shield1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [shield1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [shield1] SET  DISABLE_BROKER 
GO
ALTER DATABASE [shield1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [shield1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [shield1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [shield1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [shield1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [shield1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [shield1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [shield1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [shield1] SET  MULTI_USER 
GO
ALTER DATABASE [shield1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [shield1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [shield1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [shield1] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [shield1]
GO
/****** Object:  Table [dbo].[agentInfo]    Script Date: 4/14/2019 11:14:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[agentInfo](
	[id] [varchar](5) NOT NULL,
	[password] [varchar](50) NULL,
	[name] [varchar](50) NULL,
	[year of birth] [int] NULL,
	[height] [int] NULL,
	[gender] [bit] NULL,
	[role] [varchar](50) NULL,
	[superpower] [bit] NULL,
	[major] [varchar](50) NULL,
	[degree] [int] NULL,
	[image] [varchar](100) NULL,
 CONSTRAINT [PK_agentInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AgentMission]    Script Date: 4/14/2019 11:14:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AgentMission](
	[AgentID] [varchar](5) NOT NULL,
	[MissionCode] [varchar](4) NOT NULL,
 CONSTRAINT [PK_AgentMission] PRIMARY KEY CLUSTERED 
(
	[AgentID] ASC,
	[MissionCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[mission]    Script Date: 4/14/2019 11:14:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[mission](
	[MissionCode] [varchar](4) NOT NULL,
	[MissionName] [varchar](50) NULL,
	[Target] [varchar](50) NULL,
	[Description] [varchar](500) NULL,
	[BeginningDate] [date] NULL,
	[ExpiryDate] [date] NULL,
	[NumberOfAgent] [int] NULL,
	[Location] [varchar](50) NULL,
	[MissionStatus] [varchar](50) NULL,
 CONSTRAINT [PK_mission] PRIMARY KEY CLUSTERED 
(
	[MissionCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MissionWeapon]    Script Date: 4/14/2019 11:14:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MissionWeapon](
	[MissionCode] [varchar](4) NOT NULL,
	[WeaponCode] [varchar](5) NOT NULL,
	[ExpiryDate] [date] NULL,
 CONSTRAINT [PK_MissionWeapon] PRIMARY KEY CLUSTERED 
(
	[MissionCode] ASC,
	[WeaponCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[weapon]    Script Date: 4/14/2019 11:14:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[weapon](
	[WeaponCode] [varchar](5) NOT NULL,
	[WeaponName] [varchar](50) NULL,
	[Fund] [varchar](50) NULL,
	[Description] [varchar](500) NULL,
	[Image] [varchar](100) NULL,
 CONSTRAINT [PK_weapon] PRIMARY KEY CLUSTERED 
(
	[WeaponCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[agentInfo] ([id], [password], [name], [year of birth], [height], [gender], [role], [superpower], [major], [degree], [image]) VALUES (N'ad001', N'111', N'Nguyen Van Hoa', NULL, NULL, NULL, N'admin', NULL, NULL, NULL, NULL)
INSERT [dbo].[agentInfo] ([id], [password], [name], [year of birth], [height], [gender], [role], [superpower], [major], [degree], [image]) VALUES (N'AG001', N'123', N'Skyee', 1988, 167, 0, N'agent', 0, N'Hacker', 1, N'images\agents\skye.jpg')
INSERT [dbo].[agentInfo] ([id], [password], [name], [year of birth], [height], [gender], [role], [superpower], [major], [degree], [image]) VALUES (N'AG002', N'123', N'Grant Ward', 1980, 188, 1, N'agent', 0, N'Strength', 4, N'images\agents\ward.jpg')
INSERT [dbo].[agentInfo] ([id], [password], [name], [year of birth], [height], [gender], [role], [superpower], [major], [degree], [image]) VALUES (N'AG003', N'111', N'Phil Coulson', 1950, 1, 1, N'agent', 0, N'Leader', 7, N'images\agents\coulson.jpg')
INSERT [dbo].[agentInfo] ([id], [password], [name], [year of birth], [height], [gender], [role], [superpower], [major], [degree], [image]) VALUES (N'AG004', N'123', N'May', 1970, 180, 0, N'agent', 0, N'Pilot', 5, N'images\agents\may.jpg')
INSERT [dbo].[agentInfo] ([id], [password], [name], [year of birth], [height], [gender], [role], [superpower], [major], [degree], [image]) VALUES (N'AG005', N'123', N'Leo Fitz', 1987, 177, 1, N'agent', 0, N'Scientist', 3, N'images\agents\fitz.jpg')
INSERT [dbo].[agentInfo] ([id], [password], [name], [year of birth], [height], [gender], [role], [superpower], [major], [degree], [image]) VALUES (N'AG006', N'123', N'Jemma Simmons', 1987, 163, 0, N'agent', 0, N'Doctor', 3, N'images\agents\simmons.jpg')
INSERT [dbo].[agentInfo] ([id], [password], [name], [year of birth], [height], [gender], [role], [superpower], [major], [degree], [image]) VALUES (N'AG007', N'123', N'Tony Stark', 1970, 189, 1, N'agent', 1, N'genius, billionaire, philanthropist', 6, N'images\agents\Iron_Man.jpg')
INSERT [dbo].[agentInfo] ([id], [password], [name], [year of birth], [height], [gender], [role], [superpower], [major], [degree], [image]) VALUES (N'AG008', N'123', N'Nick Fury', 1952, 175, 1, N'agent', 0, N'leading', 7, N'images\agents\Nick_Fury.jpg')
INSERT [dbo].[agentInfo] ([id], [password], [name], [year of birth], [height], [gender], [role], [superpower], [major], [degree], [image]) VALUES (N'AG009', N'111', N'Ghost Rider', 1982, 180, 1, N'agent', 1, N'Rider, Fire', 4, N'images\agents\ghostrider.jpeg')
INSERT [dbo].[agentInfo] ([id], [password], [name], [year of birth], [height], [gender], [role], [superpower], [major], [degree], [image]) VALUES (N'AG999', N'123', N'testAgent', 1997, 178, 1, N'agent', 0, N'IT', 3, N'images\agents\ghostrider.jpeg')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG001', N'MS01')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG001', N'MS02')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG001', N'MS05')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG005', N'MS04')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG005', N'MS07')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG005', N'MS08')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG006', N'MS01')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG006', N'MS03')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG006', N'MS08')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG008', N'MS06')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG009', N'MS06')
INSERT [dbo].[AgentMission] ([AgentID], [MissionCode]) VALUES (N'AG009', N'MS09')
INSERT [dbo].[mission] ([MissionCode], [MissionName], [Target], [Description], [BeginningDate], [ExpiryDate], [NumberOfAgent], [Location], [MissionStatus]) VALUES (N'MS01', N'Kill', N'President', N'Kill xxx', CAST(0x90400B00 AS Date), CAST(0xFE410B00 AS Date), 3, N'NY', N'Accepted')
INSERT [dbo].[mission] ([MissionCode], [MissionName], [Target], [Description], [BeginningDate], [ExpiryDate], [NumberOfAgent], [Location], [MissionStatus]) VALUES (N'MS02', N'Murder', N'actor', N'Kill xxx', CAST(0xCF260B00 AS Date), CAST(0x6B430B00 AS Date), 2, N'LA', N'Accepted')
INSERT [dbo].[mission] ([MissionCode], [MissionName], [Target], [Description], [BeginningDate], [ExpiryDate], [NumberOfAgent], [Location], [MissionStatus]) VALUES (N'MS03', N'Breaking system', N'Tower', N'explore and breaking xxx tower', CAST(0x07240B00 AS Date), CAST(0x02420B00 AS Date), 1, N'Sydney', N'waiting')
INSERT [dbo].[mission] ([MissionCode], [MissionName], [Target], [Description], [BeginningDate], [ExpiryDate], [NumberOfAgent], [Location], [MissionStatus]) VALUES (N'MS04', N'Asset', N'the asset', N'Carrying a SHIELD asset between classified bases', CAST(0x233F0B00 AS Date), CAST(0x433F0B00 AS Date), 2, N'2', N'Accepted')
INSERT [dbo].[mission] ([MissionCode], [MissionName], [Target], [Description], [BeginningDate], [ExpiryDate], [NumberOfAgent], [Location], [MissionStatus]) VALUES (N'MS05', N'Turn Turn Turn', N'Hub''s systems', N'Ward and Skye plan to take the Hub''s system .', CAST(0x2F3E0B00 AS Date), CAST(0x6C3E0B00 AS Date), 2, N'Hydra', N'Accepted')
INSERT [dbo].[mission] ([MissionCode], [MissionName], [Target], [Description], [BeginningDate], [ExpiryDate], [NumberOfAgent], [Location], [MissionStatus]) VALUES (N'MS06', N'T.A.H.I.T.I.', N'Doctor', N'who previously resurrected Coulson, and so decides to go looking for the doctors that brought him back to life himself', CAST(0x4D3E0B00 AS Date), CAST(0x6C3E0B00 AS Date), 2, N'Europe', N'Accepted')
INSERT [dbo].[mission] ([MissionCode], [MissionName], [Target], [Description], [BeginningDate], [ExpiryDate], [NumberOfAgent], [Location], [MissionStatus]) VALUES (N'MS07', N'T.R.A.C.K.S.', N'Cybertek Industries', N'Ian Quinn makes a purchase from Cybertek Industries, and a security team of mercenaries is hired to escort it to Quinn''s mansion in the Italian countryside.', CAST(0x233F0B00 AS Date), CAST(0x423F0B00 AS Date), 2, N'The Italian countryside', N'waiting')
INSERT [dbo].[mission] ([MissionCode], [MissionName], [Target], [Description], [BeginningDate], [ExpiryDate], [NumberOfAgent], [Location], [MissionStatus]) VALUES (N'MS08', N'Beginning of the End', N'distress signal', N'Trapped on the ocean floor, Fitz and Simmons send out a distress signal, and devise a controlled explosive to blow the windows open and escape', CAST(0xB23E0B00 AS Date), CAST(0xF03E0B00 AS Date), 2, N'ocean floor', N'waiting')
INSERT [dbo].[mission] ([MissionCode], [MissionName], [Target], [Description], [BeginningDate], [ExpiryDate], [NumberOfAgent], [Location], [MissionStatus]) VALUES (N'MS09', N'Purpose in the Machine', N'Secret Warriors team', N'the stone is a portal. S.H.I.E.L.D. enlists Asgardian Elliot Randolph, who had investigated the portal centuries earlier when it was used by some English Lords for ritualistic sacrifices', CAST(0x90400B00 AS Date), CAST(0xB0400B00 AS Date), 2, N'S.H.I.E.L.D', N'waiting')
INSERT [dbo].[MissionWeapon] ([MissionCode], [WeaponCode], [ExpiryDate]) VALUES (N'MS02', N'WP002', CAST(0x6B430B00 AS Date))
INSERT [dbo].[MissionWeapon] ([MissionCode], [WeaponCode], [ExpiryDate]) VALUES (N'MS02', N'WP003', CAST(0x6B430B00 AS Date))
INSERT [dbo].[MissionWeapon] ([MissionCode], [WeaponCode], [ExpiryDate]) VALUES (N'MS03', N'WP001', CAST(0x02420B00 AS Date))
INSERT [dbo].[MissionWeapon] ([MissionCode], [WeaponCode], [ExpiryDate]) VALUES (N'MS05', N'WP007', CAST(0x6C3E0B00 AS Date))
INSERT [dbo].[MissionWeapon] ([MissionCode], [WeaponCode], [ExpiryDate]) VALUES (N'MS06', N'WP001', CAST(0x6C3E0B00 AS Date))
INSERT [dbo].[weapon] ([WeaponCode], [WeaponName], [Fund], [Description], [Image]) VALUES (N'WP001', N'Berserker Staff', N'Center2', N'The Berserker Staff is an ancient Asgardian weapon left behind on Earth centuries ago by an Asgardian soldier.', N'images\weapon\Berserker_staff.png')
INSERT [dbo].[weapon] ([WeaponCode], [WeaponName], [Fund], [Description], [Image]) VALUES (N'WP002', N'Night-Night Gun', N'Center', N'The Night-Night Guns are a prototype tranquilizer weapons family, including sniper rifle and handgun designs.', N'images\weapon\Night_Night_Gun.png')
INSERT [dbo].[weapon] ([WeaponCode], [WeaponName], [Fund], [Description], [Image]) VALUES (N'WP003', N'Hellfire Chain', N'Ghost Rider''s house', N'The Hellfire Chain is a metal chain that served as Hellfire''s weapon of choice after he underwent Terrigenesis. It was often used in conjunction with his fire-infusion powers in a whip-like manner.', N'images\weapon\Hellfire_Chain.jpg')
INSERT [dbo].[weapon] ([WeaponCode], [WeaponName], [Fund], [Description], [Image]) VALUES (N'WP004', N'Bobbi Morse''s Battle Staves', N'Center1', N'Bobbi Morse''s Battle Staves are the personal weapon of Bobbi Morse.', N'images\weapon\TIM_Weapons.jpg')
INSERT [dbo].[weapon] ([WeaponCode], [WeaponName], [Fund], [Description], [Image]) VALUES (N'WP005', N'Nitramene', N'Howard Stark', N'Nitramene was one of Howard Stark''s inventions created after World War II, deemed too dangerous to ever be sold. He placed a document with the formula of the compound in one of his vaults, but later discovered that someone broke into the vault and took the document among other items.', N'images\weapon\Nitramene_Bomb.png')
INSERT [dbo].[weapon] ([WeaponCode], [WeaponName], [Fund], [Description], [Image]) VALUES (N'WP006', N'Ring Blades', N'Wakandan', N'Nakia took her Ring Blades when she exiled herself along with Ramonda, Shuri and Everett Ross following Erik Killmonger''s victory over T''Challa. She left one Ring Blade to Ramonda so they could defend themselves while she briefly left to see what happened in the City of the Dead.[3]', N'images\weapon\Ring_Blades.png')
INSERT [dbo].[weapon] ([WeaponCode], [WeaponName], [Fund], [Description], [Image]) VALUES (N'WP007', N'Terrigen Crystals', N'Kree City', N'The Terrigen Crystals are a type of crystal that grow from an activated Diviner. These crystals produce the Terrigen Mist.', N'images\weapon\Terrigen_Crystals.png')
INSERT [dbo].[weapon] ([WeaponCode], [WeaponName], [Fund], [Description], [Image]) VALUES (N'WP008', N'Peruvian 0-8-4', N'HYDRA', N'The Peruvian 0-8-4 was the code given by S.H.I.E.L.D. to the Tesseract-powered weapon discovered in Peru in 2013.', N'images\weapon\peruvian.png')
ALTER TABLE [dbo].[AgentMission]  WITH CHECK ADD  CONSTRAINT [FK_AgentMission_agentInfo] FOREIGN KEY([AgentID])
REFERENCES [dbo].[agentInfo] ([id])
GO
ALTER TABLE [dbo].[AgentMission] CHECK CONSTRAINT [FK_AgentMission_agentInfo]
GO
ALTER TABLE [dbo].[AgentMission]  WITH CHECK ADD  CONSTRAINT [FK_AgentMission_mission] FOREIGN KEY([MissionCode])
REFERENCES [dbo].[mission] ([MissionCode])
GO
ALTER TABLE [dbo].[AgentMission] CHECK CONSTRAINT [FK_AgentMission_mission]
GO
ALTER TABLE [dbo].[MissionWeapon]  WITH CHECK ADD  CONSTRAINT [FK_missionWeapon_Mcode] FOREIGN KEY([MissionCode])
REFERENCES [dbo].[mission] ([MissionCode])
GO
ALTER TABLE [dbo].[MissionWeapon] CHECK CONSTRAINT [FK_missionWeapon_Mcode]
GO
ALTER TABLE [dbo].[MissionWeapon]  WITH CHECK ADD  CONSTRAINT [FK_missionWeapon_Wcode] FOREIGN KEY([WeaponCode])
REFERENCES [dbo].[weapon] ([WeaponCode])
GO
ALTER TABLE [dbo].[MissionWeapon] CHECK CONSTRAINT [FK_missionWeapon_Wcode]
GO
USE [master]
GO
ALTER DATABASE [shield1] SET  READ_WRITE 
GO
