USE [LibraryManagementSystem2]
GO
/****** Object:  Table [dbo].[librarian_details]    Script Date: 6/26/2017 2:54:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[librarian_details](
	[id] [int] NOT NULL,
	[UserName] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Email] [varchar](50) NULL,
	[Gender] [varchar](50) NULL,
	[Contact] [int] NULL,
	[role] [varchar](50) NOT NULL,
 CONSTRAINT [PK_librarian_details] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
