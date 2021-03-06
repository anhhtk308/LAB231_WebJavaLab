USE [onlineQuiz]
GO
/****** Object:  Table [dbo].[history]    Script Date: 19/7/2021 1:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[history](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[userID] [int] NOT NULL,
	[point] [float] NOT NULL,
	[date] [date] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Question]    Script Date: 19/7/2021 1:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Content] [nvarchar](max) NULL,
	[answer] [nvarchar](50) NULL,
	[date] [date] NULL,
	[opt1] [nvarchar](max) NULL,
	[opt2] [nvarchar](max) NULL,
	[opt3] [nvarchar](max) NULL,
	[opt4] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[user]    Script Date: 19/7/2021 1:27:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[userName] [nvarchar](50) NOT NULL,
	[passWord] [nvarchar](50) NOT NULL,
	[type] [bit] NOT NULL,
	[email] [nvarchar](50) NULL
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[history] ON 

INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (1, 2, 4, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (2, 2, 4.3, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (3, 3, 4.5659999847412109, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (4, 2, 5, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (5, 2, 3.3333334922790527, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (6, 2, 5, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (7, 2, 2.5, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (8, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (9, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (12, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (13, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (14, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (21, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (22, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (23, 5, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (24, 5, 10, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (25, 5, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (26, 5, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (27, 5, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (28, 5, 7.5, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (29, 5, 10, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (30, 5, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (31, 5, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (36, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (40, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (45, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (46, 0, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (47, 0, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (48, 7, 0, CAST(N'2020-04-16' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (10, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (32, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (11, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (15, 7, 5, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (16, 7, 5, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (17, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (18, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (19, 7, 6.6666669845581055, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (20, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (41, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (42, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (43, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (44, 7, 10, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (33, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (34, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (35, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (37, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (38, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (39, 7, 0, NULL)
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (49, 11, 8, CAST(N'2021-06-06' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (50, 0, 0, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (51, 12, 5, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (52, 12, 6.6666669845581055, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (53, 12, 0, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (54, 12, 0, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (55, 12, 0, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (56, 12, 10, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (57, 12, 10, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (58, 12, 10, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (59, 12, 10, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (60, 12, 0, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (61, 12, 10, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (62, 12, 10, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (63, 12, 10, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (64, 12, 10, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (65, 12, 10, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (66, 12, 8, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (67, 11, 10, CAST(N'2021-06-07' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (68, 12, 10, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (69, 12, 0, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (70, 12, 0, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (71, 12, 0, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (72, 12, 8, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (73, 12, 0, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (74, 12, 10, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (75, 12, 10, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (76, 12, 10, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (78, 12, 10, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (77, 12, 10, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (79, 12, 0, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (80, 12, 10, CAST(N'2021-06-08' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (81, 12, 8, CAST(N'2021-06-09' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (82, 12, 10, CAST(N'2021-06-09' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (83, 12, 10, CAST(N'2021-06-09' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (84, 12, 10, CAST(N'2021-06-09' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (85, 15, 10, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (86, 15, 10, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (87, 15, 5, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (104, 15, 10, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (105, 15, 6.6666669845581055, CAST(N'2021-07-13' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (106, 15, 3.3333334922790527, CAST(N'2021-07-13' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (107, 15, 0, CAST(N'2021-07-13' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (108, 15, 6.6666669845581055, CAST(N'2021-07-13' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (109, 15, 3.3333334922790527, CAST(N'2021-07-13' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (110, 15, 0, CAST(N'2021-07-13' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (111, 15, 0, CAST(N'2021-07-13' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (112, 12, 6.6666669845581055, CAST(N'2021-07-14' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (113, 12, 6.6666669845581055, CAST(N'2021-07-14' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (114, 12, 6.6666669845581055, CAST(N'2021-07-14' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (115, 15, 6.6666669845581055, CAST(N'2021-07-14' AS Date))
GO
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (116, 15, 6.6666669845581055, CAST(N'2021-07-14' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (117, 15, 6.6666669845581055, CAST(N'2021-07-14' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (118, 12, 6.6666669845581055, CAST(N'2021-07-14' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (119, 12, 6.6666669845581055, CAST(N'2021-07-16' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (88, 15, 0, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (89, 15, 3.3333334922790527, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (90, 15, 6.6666669845581055, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (91, 15, 3.3333334922790527, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (92, 15, 6.6666669845581055, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (93, 15, 6.6666669845581055, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (94, 15, 3.3333334922790527, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (95, 15, 6.6666669845581055, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (96, 15, 8, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (97, 15, 6.6666669845581055, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (98, 15, 10, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (99, 15, 6.6666669845581055, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (100, 15, 0, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (101, 15, 6.6666669845581055, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (102, 15, 7.5, CAST(N'2021-07-12' AS Date))
INSERT [dbo].[history] ([id], [userID], [point], [date]) VALUES (103, 15, 5, CAST(N'2021-07-12' AS Date))
SET IDENTITY_INSERT [dbo].[history] OFF
SET IDENTITY_INSERT [dbo].[Question] ON 

INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (18, N'Điện thoại nào sử dụng hệ điều hành IOS?', N'2', CAST(N'2021-06-07' AS Date), N'Samsung', N'Iphone', N'Xiaomi', N'VSmart')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (19, N'Ai là huấn luyện viên của ĐTQG Việt Nam ở thời điểm hiện tại?', N'3', CAST(N'2021-06-07' AS Date), N'Henrique Calisto', N'Hoàng Văn Phúc', N'Park Hang-Seo', N'Alfred Riedl')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (20, N'Những quần đảo của Việt Nam?', N'13', CAST(N'2021-06-07' AS Date), N'Hoàng Sa', N'Vân Nam', N'Trường Sa', N'Thanh Đảo')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (21, N'Trường ĐH FPT đào tạo chuyên ngành trong bao lâu?', N'4', CAST(N'2021-06-07' AS Date), N'6 Kỳ', N'7 Kỳ', N'8 Kỳ', N'9 Kỳ')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (23, N'Trường FPT đào tạo những ngành nào sau đây?', N'4', CAST(N'2021-06-09' AS Date), N'Artificial Intelligence', N'Software Engineering', N'Internet of Things', N'All of the above')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (48, N'Số nhiễm sắc thể ở người?', N'1', CAST(N'2021-07-14' AS Date), N'23 cặp', N'13 cặp', N'20 cặp', N'24 cặp')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (17, N'Thủ đô của Việt Nam?', N'1', CAST(N'2021-06-07' AS Date), N'Hà Nội', N'Vinh', N'TP Hồ Chí Minh', N'Đà Nẵng')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (53, N'xcxz', N'2', CAST(N'2021-07-16' AS Date), N'c', N'a', N's', N's')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (39, N'7 + 3 = ?', N'2', CAST(N'2021-07-14' AS Date), N'6', N'10', N'12', N'8')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (44, N'Tác phẩm "Bản án chế độ thực dân" của HCM xuất bản lần đầu tiên ở đâu?', N'2', CAST(N'2021-07-14' AS Date), N'Mỹ', N'Pháp', N'Anh', N'Nhật')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (45, N'Vị vua nào đã đặt quốc hiệu nước ta là Việt Nam như hiện nay?', N'3', CAST(N'2021-07-14' AS Date), N'Đáp án khác', N'Vua Tự Đức', N'Vua Gia Long', N'Vua Lê')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (46, N'Cầu thủ nào đã đạt danh hiệu quả bóng vàng thế giới 2006?', N'4', CAST(N'2021-07-14' AS Date), N'Cafu', N'Roberto Carlos', N'Ronaldinho', N'Fabio Canavaro')
INSERT [dbo].[Question] ([ID], [Content], [answer], [date], [opt1], [opt2], [opt3], [opt4]) VALUES (47, N'Sóng điện từ có bước sóng từ 100m – 10m được gọi là sóng gì?', N'3', CAST(N'2021-07-14' AS Date), N'Sóng siêu ngắn', N'Sóng dài', N'Sóng ngắn', N'Sóng siêu dài')
SET IDENTITY_INSERT [dbo].[Question] OFF
SET IDENTITY_INSERT [dbo].[user] ON 

INSERT [dbo].[user] ([ID], [userName], [passWord], [type], [email]) VALUES (11, N'student', N'1', 0, N'dasd@dsaa.com')
INSERT [dbo].[user] ([ID], [userName], [passWord], [type], [email]) VALUES (12, N'teacher', N'1', 1, N'dasd@dsaa.com')
INSERT [dbo].[user] ([ID], [userName], [passWord], [type], [email]) VALUES (15, N'kimanh', N'123', 0, N'anhhtkhe141704@fpt.edu.vn')
INSERT [dbo].[user] ([ID], [userName], [passWord], [type], [email]) VALUES (16, N'kimanhhoang', N'Kimanh3082', 0, N'abc@gmail.com')
INSERT [dbo].[user] ([ID], [userName], [passWord], [type], [email]) VALUES (17, N'kimanh123', N'Kimanh308', 1, N'kimanh3082@gmail.com')
INSERT [dbo].[user] ([ID], [userName], [passWord], [type], [email]) VALUES (18, N'kiman1', N'Kimanh3082', 1, N'kimanh3082@gmail.com')
INSERT [dbo].[user] ([ID], [userName], [passWord], [type], [email]) VALUES (19, N'student1', N'Kimanh308', 0, N'kimanh3082@gmail.com')
SET IDENTITY_INSERT [dbo].[user] OFF
