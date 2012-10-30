<?xml version="1.0" encoding="UTF-8"?>
<?PowerDesigner AppLocale="UTF16" ID="{C91F9C32-FC10-453D-A07E-4617CA76B2BB}" Label="" LastModificationDate="1351539860" Name="Diagramme de classes_2" Objects="108" Symbols="17" Target="Java" TargetLink="Reference" Type="{18112060-1A4B-11D1-83D9-444553540000}" signature="CLD_OBJECT_MODEL" version="15.1.0.2850"?>
<!-- Veuillez ne pas modifier ce fichier -->

<Model xmlns:a="attribute" xmlns:c="collection" xmlns:o="object">

<o:RootObject Id="o1">
<c:Children>
<o:Model Id="o2">
<a:ObjectID>C91F9C32-FC10-453D-A07E-4617CA76B2BB</a:ObjectID>
<a:Name>Diagramme de classes_2</a:Name>
<a:Code>Diagramme_de_classes_2</a:Code>
<a:CreationDate>1351534514</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539634</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:PackageOptionsText>[FolderOptions]

[FolderOptions\Class Diagram Objects]
GenerationCheckModel=Yes
GenerationPath=
GenerationOptions=
GenerationTasks=
GenerationTargets=
GenerationSelections=</a:PackageOptionsText>
<a:ModelOptionsText>[ModelOptions]

[ModelOptions\Cld]
CaseSensitive=Yes
DisplayName=Yes
EnableTrans=Yes
EnableRequirements=No
ShowClss=No
DeftAttr=int
DeftMthd=int
DeftParm=int
DeftCont=java.util.Collection
DomnDttp=Yes
DomnChck=No
DomnRule=No
SupportDelay=No
PreviewEditable=Yes
AutoRealize=No
DttpFullName=Yes
DeftClssAttrVisi=private
VBNetPreprocessingSymbols=
CSharpPreprocessingSymbols=

[ModelOptions\Cld\NamingOptionsTemplates]

[ModelOptions\Cld\ClssNamingOptions]

[ModelOptions\Cld\ClssNamingOptions\CLDPCKG]

[ModelOptions\Cld\ClssNamingOptions\CLDPCKG\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDPCKG\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDDOMN]

[ModelOptions\Cld\ClssNamingOptions\CLDDOMN\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDDOMN\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDCLASS]

[ModelOptions\Cld\ClssNamingOptions\CLDCLASS\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,FirstUpperChar)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDCLASS\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDINTF]

[ModelOptions\Cld\ClssNamingOptions\CLDINTF\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,FirstUpperChar)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDINTF\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDACTR]

[ModelOptions\Cld\ClssNamingOptions\UCDACTR\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDACTR\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDUCAS]

[ModelOptions\Cld\ClssNamingOptions\UCDUCAS\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDUCAS\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDOBJT]

[ModelOptions\Cld\ClssNamingOptions\SQDOBJT\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDOBJT\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDMSSG]

[ModelOptions\Cld\ClssNamingOptions\SQDMSSG\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\SQDMSSG\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CPDCOMP]

[ModelOptions\Cld\ClssNamingOptions\CPDCOMP\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,FirstUpperChar)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CPDCOMP\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDATTR]

[ModelOptions\Cld\ClssNamingOptions\CLDATTR\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDATTR\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDMETHOD]

[ModelOptions\Cld\ClssNamingOptions\CLDMETHOD\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDMETHOD\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDPARM]

[ModelOptions\Cld\ClssNamingOptions\CLDPARM\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDPARM\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPORT]

[ModelOptions\Cld\ClssNamingOptions\OOMPORT\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPORT\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPART]

[ModelOptions\Cld\ClssNamingOptions\OOMPART\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMPART\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDASSC]

[ModelOptions\Cld\ClssNamingOptions\CLDASSC\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,,,firstLowerWord)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\CLDASSC\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDASSC]

[ModelOptions\Cld\ClssNamingOptions\UCDASSC\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\UCDASSC\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\GNRLLINK]

[ModelOptions\Cld\ClssNamingOptions\GNRLLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\GNRLLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RQLINK]

[ModelOptions\Cld\ClssNamingOptions\RQLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RQLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RLZSLINK]

[ModelOptions\Cld\ClssNamingOptions\RLZSLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\RLZSLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DEPDLINK]

[ModelOptions\Cld\ClssNamingOptions\DEPDLINK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DEPDLINK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMACTV]

[ModelOptions\Cld\ClssNamingOptions\OOMACTV\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMACTV\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\ACDOBST]

[ModelOptions\Cld\ClssNamingOptions\ACDOBST\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\ACDOBST\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\STAT]

[ModelOptions\Cld\ClssNamingOptions\STAT\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\STAT\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDNODE]

[ModelOptions\Cld\ClssNamingOptions\DPDNODE\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDNODE\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDCMPI]

[ModelOptions\Cld\ClssNamingOptions\DPDCMPI\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDCMPI\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDASSC]

[ModelOptions\Cld\ClssNamingOptions\DPDASSC\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DPDASSC\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMVAR]

[ModelOptions\Cld\ClssNamingOptions\OOMVAR\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\OOMVAR\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FILO]

[ModelOptions\Cld\ClssNamingOptions\FILO\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=&quot;\/:*?&lt;&gt;|&quot;
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FILO\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_. &quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMEOBJ]

[ModelOptions\Cld\ClssNamingOptions\FRMEOBJ\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMEOBJ\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMELNK]

[ModelOptions\Cld\ClssNamingOptions\FRMELNK\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\FRMELNK\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DefaultClass]

[ModelOptions\Cld\ClssNamingOptions\DefaultClass\Name]
Template=
MaxLen=254
Case=M
ValidChar=
InvldChar=
AllValid=Yes
NoAccent=No
DefaultChar=_
Script=.convert_name(%Name%,&quot;_&quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Cld\ClssNamingOptions\DefaultClass\Code]
Template=
MaxLen=254
Case=M
ValidChar=&#39;a&#39;-&#39;z&#39;,&#39;A&#39;-&#39;Z&#39;,&#39;0&#39;-&#39;9&#39;,&quot;_&quot;
InvldChar=&quot; &#39;(.)+=*/&quot;
AllValid=Yes
NoAccent=Yes
DefaultChar=_
Script=.convert_code(%Code%,&quot; &quot;)
ConvTable=
ConvTablePath=%_HOME%\Fichiers de ressources\Tables de conversion

[ModelOptions\Generate]

[ModelOptions\Generate\Cdm]
CheckModel=Yes
SaveLinks=Yes
NameToCode=No
Notation=2

[ModelOptions\Generate\Pdm]
CheckModel=Yes
SaveLinks=Yes
ORMapping=No
NameToCode=No
BuildTrgr=No
TablePrefix=
RefrUpdRule=RESTRICT
RefrDelRule=RESTRICT
IndxPKName=%TABLE%_PK
IndxAKName=%TABLE%_AK
IndxFKName=%REFR%_FK
IndxThreshold=
ColnFKName=%.3:PARENT%_%COLUMN%
ColnFKNameUse=No

[ModelOptions\Generate\Xsm]
CheckModel=Yes
SaveLinks=Yes
ORMapping=No
NameToCode=No</a:ModelOptionsText>
<c:ObjectLanguage>
<o:Shortcut Id="o3">
<a:ObjectID>9C120C21-0EE3-425B-A478-3F2FDE672FE5</a:ObjectID>
<a:Name>Java</a:Name>
<a:Code>Java</a:Code>
<a:CreationDate>1351534514</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351534514</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:TargetStereotype/>
<a:TargetID>0DEDDB90-46E2-45A0-886E-411709DA0DC9</a:TargetID>
<a:TargetClassID>1811206C-1A4B-11D1-83D9-444553540000</a:TargetClassID>
</o:Shortcut>
</c:ObjectLanguage>
<c:ExtendedModelDefinitions>
<o:Shortcut Id="o4">
<a:ObjectID>5BCBD623-D7BB-4DDC-B68B-8EE501A96A5F</a:ObjectID>
<a:Name>WSDL for Java</a:Name>
<a:Code>WSDLJava</a:Code>
<a:CreationDate>1351534514</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351534514</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:TargetStereotype/>
<a:TargetID>C8F5F7B2-CF9D-4E98-8301-959BB6E86C8A</a:TargetID>
<a:TargetClassID>186C8AC3-D3DC-11D3-881C-00508B03C75C</a:TargetClassID>
</o:Shortcut>
</c:ExtendedModelDefinitions>
<c:ClassDiagrams>
<o:ClassDiagram Id="o5">
<a:ObjectID>36EECFD4-EEB2-42F7-9BAC-5EC08A3B1CB9</a:ObjectID>
<a:Name>DiagrammeClasses_1</a:Name>
<a:Code>DiagrammeClasses_1</a:Code>
<a:CreationDate>1351534514</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539634</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DisplayPreferences>[DisplayPreferences]

[DisplayPreferences\CLD]

[DisplayPreferences\General]
Adjust to text=Yes
Snap Grid=No
Constrain Labels=Yes
Display Grid=No
Show Page Delimiter=Yes
Grid size=0
Graphic unit=2
Window color=255, 255, 255
Background image=
Background mode=8
Watermark image=
Watermark mode=8
Show watermark on screen=No
Gradient mode=0
Gradient end color=255, 255, 255
Show Swimlane=No
SwimlaneVert=Yes
TreeVert=No
CompDark=0

[DisplayPreferences\Object]
Mode=0
Trunc Length=80
Word Length=80
Word Text=!&quot;&quot;#$%&amp;&#39;()*+,-./:;&lt;=&gt;?@[\]^_`{|}~
Shortcut IntIcon=Yes
Shortcut IntLoct=Yes
Shortcut IntFullPath=No
Shortcut IntLastPackage=Yes
Shortcut ExtIcon=Yes
Shortcut ExtLoct=No
Shortcut ExtFullPath=No
Shortcut ExtLastPackage=Yes
Shortcut ExtIncludeModl=Yes
EObjShowStrn=Yes
ExtendedObject.Comment=No
ExtendedObject.IconPicture=No
ExtendedObject_SymbolLayout=
ELnkShowStrn=Yes
ELnkShowName=Yes
ExtendedLink_SymbolLayout=
FileObject.Stereotype=No
FileObject.DisplayName=Yes
FileObject.LocationOrName=No
FileObject.IconPicture=No
FileObject.IconMode=Yes
FileObject_SymbolLayout=
PckgShowStrn=Yes
Package.Comment=No
Package.IconPicture=No
Package_SymbolLayout=
Display Model Version=Yes
Class.IconPicture=No
Class_SymbolLayout=
Interface.IconPicture=No
Interface_SymbolLayout=
Port.IconPicture=No
Port_SymbolLayout=
ClssShowSttr=Yes
Class.Comment=No
ClssShowCntr=Yes
ClssShowAttr=Yes
ClssAttrTrun=No
ClssAttrMax=3
ClssShowMthd=Yes
ClssMthdTrun=No
ClssMthdMax=3
ClssShowInnr=Yes
IntfShowSttr=Yes
Interface.Comment=No
IntfShowAttr=Yes
IntfAttrTrun=No
IntfAttrMax=3
IntfShowMthd=Yes
IntfMthdTrun=No
IntfMthdMax=3
IntfShowCntr=Yes
IntfShowInnr=Yes
PortShowName=Yes
PortShowType=No
PortShowMult=No
AttrShowVisi=Yes
AttrVisiFmt=1
AttrShowStrn=Yes
AttrShowDttp=Yes
AttrShowDomn=No
AttrShowInit=Yes
MthdShowVisi=Yes
MthdVisiFmt=1
MthdShowStrn=Yes
MthdShowRttp=Yes
MthdShowParm=Yes
AsscShowName=No
AsscShowCntr=Yes
AsscShowRole=Yes
AsscShowOrdr=Yes
AsscShowMult=Yes
AsscMultStr=Yes
AsscShowStrn=No
GnrlShowName=No
GnrlShowStrn=Yes
GnrlShowCntr=Yes
RlzsShowName=No
RlzsShowStrn=Yes
RlzsShowCntr=Yes
DepdShowName=No
DepdShowStrn=Yes
DepdShowCntr=Yes
RqlkShowName=No
RqlkShowStrn=Yes
RqlkShowCntr=Yes

[DisplayPreferences\Symbol]

[DisplayPreferences\Symbol\FRMEOBJ]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=6000
Height=2000
Brush color=255 255 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=64
Brush gradient color=192 192 192
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 255 128 128
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\FRMELNK]
CENTERFont=Arial,8,N
CENTERFont color=0, 0, 0
Line style=2
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\FILO]
OBJSTRNFont=Arial,8,N
OBJSTRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LCNMFont=Arial,8,N
LCNMFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=Yes
Keep center=Yes
Keep size=No
Width=2400
Height=2400
Brush color=255 255 255
Fill Color=No
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 0 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDPCKG]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=3600
Brush color=255 255 192
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 178 178 178
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDCLASS]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
CNTRFont=Arial,8,N
CNTRFont color=0, 0, 0
AttributesFont=Arial,8,N
AttributesFont color=0, 0, 0
ClassPrimaryAttributeFont=Arial,8,U
ClassPrimaryAttributeFont color=0, 0, 0
OperationsFont=Arial,8,N
OperationsFont color=0, 0, 0
InnerClassifiersFont=Arial,8,N
InnerClassifiersFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=3600
Brush color=174 228 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDINTF]
STRNFont=Arial,8,N
STRNFont color=0, 0, 0
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
CNTRFont=Arial,8,N
CNTRFont color=0, 0, 0
AttributesFont=Arial,8,N
AttributesFont color=0, 0, 0
OperationsFont=Arial,8,N
OperationsFont color=0, 0, 0
InnerClassifiersFont=Arial,8,N
InnerClassifiersFont color=0, 0, 0
LABLFont=Arial,8,N
LABLFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=4800
Height=3600
Brush color=208 208 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\OOMPORT]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Width=800
Height=800
Brush color=174 228 255
Fill Color=Yes
Brush style=6
Brush bitmap mode=12
Brush gradient mode=65
Brush gradient color=255 255 255
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDASSC]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
MULAFont=Arial,8,N
MULAFont color=0, 0, 0
Line style=2
Pen=1 0 0 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\INNERLINK]
Line style=2
Pen=1 0 0 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\CLDACLK]
Line style=2
Pen=2 0 0 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\GNRLLINK]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
Line style=2
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\RLZSLINK]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
Line style=2
Pen=3 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\RQLINK]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
Line style=2
Pen=1 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\DEPDLINK]
DISPNAMEFont=Arial,8,N
DISPNAMEFont color=0, 0, 0
Line style=2
Pen=2 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\USRDEPD]
OBJXSTRFont=Arial,8,N
OBJXSTRFont color=0, 0, 0
Line style=2
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=2 0 128 128 255
Shadow color=192 192 192
Shadow=0

[DisplayPreferences\Symbol\Free Symbol]
Free TextFont=Arial,8,N
Free TextFont color=0, 0, 0
Line style=2
AutoAdjustToText=Yes
Keep aspect=No
Keep center=No
Keep size=No
Brush color=255 255 255
Fill Color=Yes
Brush style=1
Brush bitmap mode=12
Brush gradient mode=0
Brush gradient color=118 118 118
Brush background image=
Custom shape=
Custom text mode=0
Pen=1 0 0 0 255
Shadow color=192 192 192
Shadow=0</a:DisplayPreferences>
<a:PaperSize>(8268, 11693)</a:PaperSize>
<a:PageMargins>((315,354), (433,354))</a:PageMargins>
<a:PageOrientation>1</a:PageOrientation>
<a:PaperSource>15</a:PaperSource>
<c:Symbols>
<o:GeneralizationSymbol Id="o6">
<a:CreationDate>1351538141</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:Rect>((-32254,12040), (-31254,28040))</a:Rect>
<a:ListOfPoints>((-31754,12040),(-31754,28040))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>16744576</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o7"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o8"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o9"/>
</c:Object>
</o:GeneralizationSymbol>
<o:GeneralizationSymbol Id="o10">
<a:CreationDate>1351538143</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:Rect>((-31754,27540), (32246,28540))</a:Rect>
<a:ListOfPoints>((32246,28040),(-31754,28040))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>16744576</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o11"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o8"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o12"/>
</c:Object>
</o:GeneralizationSymbol>
<o:GeneralizationSymbol Id="o13">
<a:CreationDate>1351538145</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:Rect>((-31754,11540), (12246,12540))</a:Rect>
<a:ListOfPoints>((12246,12040),(-31754,12040))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>16744576</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o14"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o7"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o15"/>
</c:Object>
</o:GeneralizationSymbol>
<o:GeneralizationSymbol Id="o16">
<a:CreationDate>1351538146</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:Rect>((-32254,-1960), (-31254,12040))</a:Rect>
<a:ListOfPoints>((-31754,-1960),(-31754,12040))</a:ListOfPoints>
<a:CornerStyle>2</a:CornerStyle>
<a:ArrowStyle>7</a:ArrowStyle>
<a:LineColor>16744576</a:LineColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>DISPNAME 0 Arial,8,N</a:FontList>
<c:SourceSymbol>
<o:ClassSymbol Ref="o17"/>
</c:SourceSymbol>
<c:DestinationSymbol>
<o:ClassSymbol Ref="o7"/>
</c:DestinationSymbol>
<c:Object>
<o:Generalization Ref="o18"/>
</c:Object>
</o:GeneralizationSymbol>
<o:ClassSymbol Id="o19">
<a:CreationDate>1351538098</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-62507,-16728), (-44999,-7190))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o20"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o8">
<a:CreationDate>1351538100</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-54979,23751), (-8529,32328))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o21"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o7">
<a:CreationDate>1351538103</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-62947,10150), (-559,13929))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o22"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o14">
<a:CreationDate>1351538104</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((9396,10150), (15094,13929))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o23"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o11">
<a:CreationDate>1351538104</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((1544,26150), (62946,29929))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o24"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o17">
<a:CreationDate>1351538105</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-61099,-4808), (-2412,890))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o25"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o26">
<a:CreationDate>1351538535</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-62894,-24807), (-12612,-19111))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o27"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o28">
<a:CreationDate>1351539275</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-22623,-32328), (-8885,-27590))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o29"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o30">
<a:CreationDate>1351539323</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-6624,-32328), (7114,-27590))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o31"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o32">
<a:CreationDate>1351539355</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-8107,-24328), (8597,-19590))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o33"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o34">
<a:CreationDate>1351539395</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-62445,-32328), (-45061,-27590))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o35"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o36">
<a:CreationDate>1351539431</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-42137,-32328), (-25371,-27590))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o37"/>
</c:Object>
</o:ClassSymbol>
<o:ClassSymbol Id="o38">
<a:CreationDate>1351539634</a:CreationDate>
<a:ModificationDate>1351539860</a:ModificationDate>
<a:IconMode>-1</a:IconMode>
<a:Rect>((-42569,-16248), (-24939,-7670))</a:Rect>
<a:LineColor>16744448</a:LineColor>
<a:FillColor>16770222</a:FillColor>
<a:ShadowColor>12632256</a:ShadowColor>
<a:FontList>STRN 0 Arial,8,N
DISPNAME 0 Arial,8,N
CNTR 0 Arial,8,N
Attributes 0 Arial,8,N
ClassPrimaryAttribute 0 Arial,8,U
Operations 0 Arial,8,N
InnerClassifiers 0 Arial,8,N
LABL 0 Arial,8,N</a:FontList>
<a:BrushStyle>6</a:BrushStyle>
<a:GradientFillMode>65</a:GradientFillMode>
<a:GradientEndColor>16777215</a:GradientEndColor>
<c:Object>
<o:Class Ref="o39"/>
</c:Object>
</o:ClassSymbol>
</c:Symbols>
</o:ClassDiagram>
</c:ClassDiagrams>
<c:DefaultDiagram>
<o:ClassDiagram Ref="o5"/>
</c:DefaultDiagram>
<c:Classes>
<o:Class Id="o20">
<a:ObjectID>5D307DC5-B64D-47A3-B493-76AFD2177401</a:ObjectID>
<a:Name>ErreurCaisse</a:Name>
<a:Code>ErreurCaisse</a:Code>
<a:CreationDate>1351538098</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539838</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o40">
<a:ObjectID>CBBCBF5E-1302-463E-AB2F-F785DAF9CC1D</a:ObjectID>
<a:Name>erreurCaisseId</a:Name>
<a:Code>erreurCaisseId</a:Code>
<a:CreationDate>1351539174</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539213</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>int</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o41">
<a:ObjectID>EAB9BFE8-6FAD-4361-AB88-44DE6FCEECFE</a:ObjectID>
<a:Name>agent</a:Name>
<a:Code>agent</a:Code>
<a:CreationDate>1351539547</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539618</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>Agent</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
<c:ObjectDataType>
<o:Class Ref="o21"/>
</c:ObjectDataType>
</o:Attribute>
<o:Attribute Id="o42">
<a:ObjectID>905CE7D3-CC33-4BF0-A7D9-242EB9EFB80E</a:ObjectID>
<a:Name>typeErreur</a:Name>
<a:Code>typeErreur</a:Code>
<a:CreationDate>1351539547</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539618</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>TypeErreur</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
<c:ObjectDataType>
<o:Class Ref="o31"/>
</c:ObjectDataType>
</o:Attribute>
<o:Attribute Id="o43">
<a:ObjectID>8AB22735-941C-453C-BF5C-798C861C39FE</a:ObjectID>
<a:Name>agence</a:Name>
<a:Code>agence</a:Code>
<a:CreationDate>1351539547</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539618</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>Agence</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
<c:ObjectDataType>
<o:Class Ref="o27"/>
</c:ObjectDataType>
</o:Attribute>
<o:Attribute Id="o44">
<a:ObjectID>B1607B0B-A6BC-40D3-AF6C-A30FD80E72D3</a:ObjectID>
<a:Name>statusRegularisation</a:Name>
<a:Code>statusRegularisation</a:Code>
<a:CreationDate>1351539547</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539618</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>StatusRegularisation</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
<c:ObjectDataType>
<o:Class Ref="o35"/>
</c:ObjectDataType>
</o:Attribute>
<o:Attribute Id="o45">
<a:ObjectID>CD4648DC-FD0E-44D4-9255-DB65098AE5BA</a:ObjectID>
<a:Name>dateVacation</a:Name>
<a:Code>dateVacation</a:Code>
<a:CreationDate>1351539174</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539213</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.util.Date</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o46">
<a:ObjectID>11A1BCD9-41C4-4EB3-9471-BE60BCC71710</a:ObjectID>
<a:Name>montant</a:Name>
<a:Code>montant</a:Code>
<a:CreationDate>1351539174</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539213</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>float</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o21">
<a:ObjectID>4A06BA41-F2CB-4C96-B2C1-CA536C4C8EA8</a:ObjectID>
<a:Name>Agent</a:Name>
<a:Code>Agent</a:Code>
<a:CreationDate>1351538100</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539838</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o47">
<a:ObjectID>3D44301E-B850-4FE3-815B-0A9828859326</a:ObjectID>
<a:Name>codeAgent</a:Name>
<a:Code>codeAgent</a:Code>
<a:CreationDate>1351539039</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539087</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o48">
<a:ObjectID>47A301CF-E719-4F99-8CBA-BA54AB362E12</a:ObjectID>
<a:Name>typeAgent</a:Name>
<a:Code>typeAgent</a:Code>
<a:CreationDate>1351539483</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539539</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>TypeAgent</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
<c:ObjectDataType>
<o:Class Ref="o29"/>
</c:ObjectDataType>
</o:Attribute>
<o:Attribute Id="o49">
<a:ObjectID>89971804-F56E-4A3F-B58A-8CE845DD92E6</a:ObjectID>
<a:Name>mail</a:Name>
<a:Code>mail</a:Code>
<a:CreationDate>1351539039</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539087</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o50">
<a:ObjectID>27B0C807-20E9-4B88-833F-F4688701DF1D</a:ObjectID>
<a:Name>nom</a:Name>
<a:Code>nom</a:Code>
<a:CreationDate>1351539039</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539087</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o51">
<a:ObjectID>D6CCB354-20C9-42DC-B3AA-57E978E30310</a:ObjectID>
<a:Name>prenom</a:Name>
<a:Code>prenom</a:Code>
<a:CreationDate>1351539039</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539087</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o52">
<a:ObjectID>AB972671-D1A9-4902-A017-4B676345C0B5</a:ObjectID>
<a:Name>motDePasse</a:Name>
<a:Code>motDePasse</a:Code>
<a:CreationDate>1351539117</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539138</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
<c:Operations>
<o:Operation Id="o53">
<a:ObjectID>3CFD8D34-02A9-43EE-8A54-83D87245E247</a:ObjectID>
<a:Name>regulariserErreurCaisse</a:Name>
<a:Code>regulariserErreurCaisse</a:Code>
<a:CreationDate>1351538427</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538500</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:ReturnType>int</a:ReturnType>
<a:TemplateBody>%DefaultBody%</a:TemplateBody>
<c:Parameters>
<o:Parameter Id="o54">
<a:ObjectID>2D898456-4298-4A8D-B2FE-1A65AD40BC8B</a:ObjectID>
<a:Name>montantRegulation</a:Name>
<a:Code>montantRegulation</a:Code>
<a:CreationDate>1351538446</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538500</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>float</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o55">
<a:ObjectID>75D36B26-B6CB-46C8-BEAC-F009F46E1A98</a:ObjectID>
<a:Name>codeAgentRegulateur</a:Name>
<a:Code>codeAgentRegulateur</a:Code>
<a:CreationDate>1351538446</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538500</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o56">
<a:ObjectID>6DB2CD24-B4CF-4B5D-B1D4-F4F946A4DC24</a:ObjectID>
<a:Name>motifRegulation</a:Name>
<a:Code>motifRegulation</a:Code>
<a:CreationDate>1351538446</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538500</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
</c:Parameters>
</o:Operation>
</c:Operations>
</o:Class>
<o:Class Id="o22">
<a:ObjectID>C6E3DF4C-C271-4847-A3BE-91DA597C6A73</a:ObjectID>
<a:Name>AgentSuperieur</a:Name>
<a:Code>AgentSuperieur</a:Code>
<a:CreationDate>1351538103</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538275</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Operations>
<o:Operation Id="o57">
<a:ObjectID>1A5EDD91-AAAF-4AAE-B6DC-D433D48DBA8D</a:ObjectID>
<a:Name>consulterErreursCaisseAgence</a:Name>
<a:Code>consulterErreursCaisseAgence</a:Code>
<a:CreationDate>1351538264</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538330</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:ReturnType>ErreurCaisse</a:ReturnType>
<a:Array>1</a:Array>
<a:TemplateBody>%DefaultBody%</a:TemplateBody>
<c:ObjectReturnType>
<o:Class Ref="o20"/>
</c:ObjectReturnType>
<c:Parameters>
<o:Parameter Id="o58">
<a:ObjectID>6848B8B4-0BBE-443D-A30D-26DD966AA3EC</a:ObjectID>
<a:Name>codeAgence</a:Name>
<a:Code>codeAgence</a:Code>
<a:CreationDate>1351538275</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538330</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o59">
<a:ObjectID>8EDBC565-289F-4FB9-ACAD-D7F85849716B</a:ObjectID>
<a:Name>typeErreur</a:Name>
<a:Code>typeErreur</a:Code>
<a:CreationDate>1351538275</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538330</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o60">
<a:ObjectID>A149C82D-D318-44BE-9A84-EA2DFD132D23</a:ObjectID>
<a:Name>statusErreur</a:Name>
<a:Code>statusErreur</a:Code>
<a:CreationDate>1351538275</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538330</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>int</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o61">
<a:ObjectID>9C62976F-377A-4B9E-86F4-0708665F3B32</a:ObjectID>
<a:Name>dateDebut</a:Name>
<a:Code>dateDebut</a:Code>
<a:CreationDate>1351538275</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538330</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.util.Date</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o62">
<a:ObjectID>26394FA4-CC3C-4232-A082-3AD81452F9E9</a:ObjectID>
<a:Name>dateFin</a:Name>
<a:Code>dateFin</a:Code>
<a:CreationDate>1351538275</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538330</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.util.Date</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
</c:Parameters>
</o:Operation>
</c:Operations>
</o:Class>
<o:Class Id="o23">
<a:ObjectID>76BDCF0D-1287-4454-8043-7D3A9293523D</a:ObjectID>
<a:Name>AgentDirection</a:Name>
<a:Code>AgentDirection</a:Code>
<a:CreationDate>1351538104</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538127</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
</o:Class>
<o:Class Id="o24">
<a:ObjectID>6A291617-03BC-400F-8605-3D3CB4D93938</a:ObjectID>
<a:Name>AgentGuichet</a:Name>
<a:Code>AgentGuichet</a:Code>
<a:CreationDate>1351538104</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538357</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Operations>
<o:Operation Id="o63">
<a:ObjectID>301EBCD8-043D-484E-AFAE-889D97C2AC9C</a:ObjectID>
<a:Name>consulterErreursCaisseAgent(</a:Name>
<a:Code>consulterErreursCaisseAgent_</a:Code>
<a:CreationDate>1351538344</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538416</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:ReturnType>ErreurCaisse</a:ReturnType>
<a:Array>1</a:Array>
<a:TemplateBody>%DefaultBody%</a:TemplateBody>
<c:ObjectReturnType>
<o:Class Ref="o20"/>
</c:ObjectReturnType>
<c:Parameters>
<o:Parameter Id="o64">
<a:ObjectID>3340F404-5D66-47DD-827A-9A2FF536D5BC</a:ObjectID>
<a:Name>codeAgent</a:Name>
<a:Code>codeAgent</a:Code>
<a:CreationDate>1351538368</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538416</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o65">
<a:ObjectID>601D36B7-69A4-446E-A33B-46B87588B022</a:ObjectID>
<a:Name>typeErreur</a:Name>
<a:Code>typeErreur</a:Code>
<a:CreationDate>1351538368</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538416</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o66">
<a:ObjectID>6A218B23-1F10-4A5D-9388-80041CDCED6F</a:ObjectID>
<a:Name>statusErreur</a:Name>
<a:Code>statusErreur</a:Code>
<a:CreationDate>1351538368</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538416</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>int</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o67">
<a:ObjectID>C3F983B2-5058-4D26-8F6F-54C52FA2F61F</a:ObjectID>
<a:Name>dateDebut</a:Name>
<a:Code>dateDebut</a:Code>
<a:CreationDate>1351538368</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538416</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.util.Date</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o68">
<a:ObjectID>0AA1004C-D775-443F-B6BF-75726043ABCD</a:ObjectID>
<a:Name>dateFin</a:Name>
<a:Code>dateFin</a:Code>
<a:CreationDate>1351538368</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538416</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.util.Date</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
</c:Parameters>
</o:Operation>
</c:Operations>
</o:Class>
<o:Class Id="o25">
<a:ObjectID>69CA04E0-0D8F-4F5B-A702-333D41AB817F</a:ObjectID>
<a:Name>AgentComptable</a:Name>
<a:Code>AgentComptable</a:Code>
<a:CreationDate>1351538105</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538887</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Operations>
<o:Operation Id="o69">
<a:ObjectID>43BF0FBE-9082-4E35-818C-1DA241AD90E5</a:ObjectID>
<a:Name>declarerErreurCaisse</a:Name>
<a:Code>declarerErreurCaisse</a:Code>
<a:CreationDate>1351538162</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538246</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:ReturnType>int</a:ReturnType>
<a:TemplateBody>%DefaultBody%</a:TemplateBody>
<c:Parameters>
<o:Parameter Id="o70">
<a:ObjectID>EAE309A2-8FC2-496D-AAA3-4A67F6624254</a:ObjectID>
<a:Name>codeAgence</a:Name>
<a:Code>codeAgence</a:Code>
<a:CreationDate>1351538181</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538215</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o71">
<a:ObjectID>7E3A5434-BD62-44D9-A57B-FD5146188956</a:ObjectID>
<a:Name>codeAgent</a:Name>
<a:Code>codeAgent</a:Code>
<a:CreationDate>1351538181</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538215</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o72">
<a:ObjectID>82FA3159-CF12-475E-8739-9267D887679F</a:ObjectID>
<a:Name>dateVacation</a:Name>
<a:Code>dateVacation</a:Code>
<a:CreationDate>1351538181</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538215</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.util.Date</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o73">
<a:ObjectID>5EC14098-0B75-4783-A3C4-2B60D1FBCA0B</a:ObjectID>
<a:Name>typeErreur</a:Name>
<a:Code>typeErreur</a:Code>
<a:CreationDate>1351538217</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538246</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o74">
<a:ObjectID>C2D5072E-49DA-4835-9331-0EB44A8EE51B</a:ObjectID>
<a:Name>montant</a:Name>
<a:Code>montant</a:Code>
<a:CreationDate>1351538217</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538246</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>float</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
</c:Parameters>
</o:Operation>
<o:Operation Id="o75">
<a:ObjectID>E2E5E317-D239-46AD-BAFD-0F73D69ED41A</a:ObjectID>
<a:Name>isBilanDepasse</a:Name>
<a:Code>isBilanDepasse</a:Code>
<a:CreationDate>1351538820</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538887</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:ReturnType>boolean</a:ReturnType>
<a:TemplateBody>%DefaultBody%</a:TemplateBody>
</o:Operation>
<o:Operation Id="o76">
<a:ObjectID>63DD9D2E-8435-479D-AAA3-3EF88DC1C8CC</a:ObjectID>
<a:Name>envoyerMail</a:Name>
<a:Code>envoyerMail</a:Code>
<a:CreationDate>1351538820</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538906</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:ReturnType>void</a:ReturnType>
<a:TemplateBody>%DefaultBody%</a:TemplateBody>
<c:Parameters>
<o:Parameter Id="o77">
<a:ObjectID>A0CEFE71-E81E-4CAF-AB11-15984E08522D</a:ObjectID>
<a:Name>mail</a:Name>
<a:Code>mail</a:Code>
<a:CreationDate>1351538887</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538906</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
</c:Parameters>
</o:Operation>
</c:Operations>
</o:Class>
<o:Class Id="o27">
<a:ObjectID>E039DAE3-8F09-4DAA-8618-5349A54156DC</a:ObjectID>
<a:Name>Agence</a:Name>
<a:Code>Agence</a:Code>
<a:CreationDate>1351538535</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539618</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o78">
<a:ObjectID>DDFDC249-95AC-495C-8F17-34F6DD52C46F</a:ObjectID>
<a:Name>codeAgence</a:Name>
<a:Code>codeAgence</a:Code>
<a:CreationDate>1351539088</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539095</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o79">
<a:ObjectID>E9552AA2-5426-4A83-BB19-08729AE730ED</a:ObjectID>
<a:Name>nomAgence</a:Name>
<a:Code>nomAgence</a:Code>
<a:CreationDate>1351539088</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539095</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
<c:Operations>
<o:Operation Id="o80">
<a:ObjectID>23CFB92F-5E74-4DC6-9219-D9C4F24A7C30</a:ObjectID>
<a:Name>bilanJourneeErreursCaisse</a:Name>
<a:Code>bilanJourneeErreursCaisse</a:Code>
<a:CreationDate>1351538538</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538608</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:ReturnType>float</a:ReturnType>
<a:TemplateBody>%DefaultBody%</a:TemplateBody>
<c:Parameters>
<o:Parameter Id="o81">
<a:ObjectID>B3B96B70-8181-46B2-BE2B-CD6AC08AF214</a:ObjectID>
<a:Name>codeAgence</a:Name>
<a:Code>codeAgence</a:Code>
<a:CreationDate>1351538559</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538608</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o82">
<a:ObjectID>6E33B1A4-F5FF-4051-9207-B17F1E284D52</a:ObjectID>
<a:Name>dateVacation</a:Name>
<a:Code>dateVacation</a:Code>
<a:CreationDate>1351538559</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538608</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.util.Date</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o83">
<a:ObjectID>D54A220B-E7CF-4434-8B17-BD1CCC059067</a:ObjectID>
<a:Name>typeErreur</a:Name>
<a:Code>typeErreur</a:Code>
<a:CreationDate>1351538559</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538608</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o84">
<a:ObjectID>1DAE6AFC-F2AB-4DDF-93C5-E20B1B936B06</a:ObjectID>
<a:Name>statusErreur</a:Name>
<a:Code>statusErreur</a:Code>
<a:CreationDate>1351538559</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538608</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>int</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
</c:Parameters>
</o:Operation>
<o:Operation Id="o85">
<a:ObjectID>DD607062-B6C7-4ADF-8739-5FA99A2AF872</a:ObjectID>
<a:Name>bilanErreursCaisse</a:Name>
<a:Code>bilanErreursCaisse</a:Code>
<a:CreationDate>1351538616</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538668</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:ReturnType>float</a:ReturnType>
<a:TemplateBody>%DefaultBody%</a:TemplateBody>
<c:Parameters>
<o:Parameter Id="o86">
<a:ObjectID>3968DFAC-7921-48B9-B0C4-B7DC6415CD8C</a:ObjectID>
<a:Name>codeAgence</a:Name>
<a:Code>codeAgence</a:Code>
<a:CreationDate>1351538616</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538668</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:WSDLDataType>xsd:string</a:WSDLDataType>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o87">
<a:ObjectID>5D06BBF3-4D45-49B0-96CE-B72C99B21706</a:ObjectID>
<a:Name>dateVacation</a:Name>
<a:Code>dateVacation</a:Code>
<a:CreationDate>1351538616</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538668</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:WSDLDataType>xsd:date</a:WSDLDataType>
<a:Parameter.DataType>java.util.Date</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o88">
<a:ObjectID>92EC4B54-9052-4784-941B-CA2E7C8C7B78</a:ObjectID>
<a:Name>typeErreur</a:Name>
<a:Code>typeErreur</a:Code>
<a:CreationDate>1351538616</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538668</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:WSDLDataType>xsd:string</a:WSDLDataType>
<a:Parameter.DataType>java.lang.String</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
<o:Parameter Id="o89">
<a:ObjectID>180786A2-6706-4644-A7E4-31E225FA5EA2</a:ObjectID>
<a:Name>statusErreur</a:Name>
<a:Code>statusErreur</a:Code>
<a:CreationDate>1351538616</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538668</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:Parameter.DataType>int</a:Parameter.DataType>
<a:ParameterType>I</a:ParameterType>
</o:Parameter>
</c:Parameters>
</o:Operation>
</c:Operations>
</o:Class>
<o:Class Id="o29">
<a:ObjectID>E8327764-9902-4A0C-A04A-204901B28EBA</a:ObjectID>
<a:Name>TypeAgent</a:Name>
<a:Code>TypeAgent</a:Code>
<a:CreationDate>1351539275</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539539</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o90">
<a:ObjectID>1562ED71-051C-48C9-9948-E394168B8CFE</a:ObjectID>
<a:Name>codeTypeAgent</a:Name>
<a:Code>codeTypeAgent</a:Code>
<a:CreationDate>1351539275</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539311</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o91">
<a:ObjectID>706A14B2-4581-4282-BF01-7F0693E189B8</a:ObjectID>
<a:Name>nomTypeAgent</a:Name>
<a:Code>nomTypeAgent</a:Code>
<a:CreationDate>1351539275</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539311</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o31">
<a:ObjectID>571BEB64-D889-4515-95EE-79AF689BE0DF</a:ObjectID>
<a:Name>TypeErreur</a:Name>
<a:Code>TypeErreur</a:Code>
<a:CreationDate>1351539323</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539618</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o92">
<a:ObjectID>A89122DC-DE9C-48E2-A03A-BA8ED9850E45</a:ObjectID>
<a:Name>codeTypeErreur</a:Name>
<a:Code>codeTypeErreur</a:Code>
<a:CreationDate>1351539323</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539347</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o93">
<a:ObjectID>66F961E9-890C-4DC8-B7C3-E64265B35352</a:ObjectID>
<a:Name>nomTypeErreur</a:Name>
<a:Code>nomTypeErreur</a:Code>
<a:CreationDate>1351539323</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539347</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o33">
<a:ObjectID>E7035BD8-DB05-429C-9F7D-D79A56F8943E</a:ObjectID>
<a:Name>TypeRegularisation</a:Name>
<a:Code>TypeRegularisation</a:Code>
<a:CreationDate>1351539355</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539838</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o94">
<a:ObjectID>EC9FE315-A3CB-4545-B77C-E9B8023DC810</a:ObjectID>
<a:Name>codeTypeRegularisation</a:Name>
<a:Code>codeTypeRegularisation</a:Code>
<a:CreationDate>1351539355</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539376</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o95">
<a:ObjectID>E0B3F844-B125-468F-ADB3-2B264CA30300</a:ObjectID>
<a:Name>nomTypeRegularisation</a:Name>
<a:Code>nomTypeRegularisation</a:Code>
<a:CreationDate>1351539355</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539376</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o35">
<a:ObjectID>2B09A396-DF6B-4486-B110-7DD48179AE8B</a:ObjectID>
<a:Name>StatusRegularisation</a:Name>
<a:Code>StatusRegularisation</a:Code>
<a:CreationDate>1351539395</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539618</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o96">
<a:ObjectID>41598BCB-9CBB-43DE-8177-96623CA93EB1</a:ObjectID>
<a:Name>codeStatusRegularisation</a:Name>
<a:Code>codeStatusRegularisation</a:Code>
<a:CreationDate>1351539395</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539421</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o97">
<a:ObjectID>B8985FC5-182B-4E87-B7ED-3B51D22204DD</a:ObjectID>
<a:Name>nomStatusRegularisation</a:Name>
<a:Code>nomStatusRegularisation</a:Code>
<a:CreationDate>1351539395</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539421</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o37">
<a:ObjectID>065F429A-F6E3-4778-B338-06600556C9FA</a:ObjectID>
<a:Name>MotifRegularisation</a:Name>
<a:Code>MotifRegularisation</a:Code>
<a:CreationDate>1351539431</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539838</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o98">
<a:ObjectID>E0BAF495-C234-48B3-80C4-DED3B2994AFC</a:ObjectID>
<a:Name>codeMotifRegularisation</a:Name>
<a:Code>codeMotifRegularisation</a:Code>
<a:CreationDate>1351539431</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539461</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o99">
<a:ObjectID>FF376DA3-2E98-4DBE-9848-2B36CFA383D4</a:ObjectID>
<a:Name>nomMotifRegularisation</a:Name>
<a:Code>nomMotifRegularisation</a:Code>
<a:CreationDate>1351539431</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539461</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.lang.String</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
<o:Class Id="o39">
<a:ObjectID>F72C5A07-E18C-4C3E-B29A-974D069BE123</a:ObjectID>
<a:Name>ErreursCaisseRegularisation</a:Name>
<a:Code>ErreursCaisseRegularisation</a:Code>
<a:CreationDate>1351539634</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539838</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:UseParentNamespace>0</a:UseParentNamespace>
<c:Attributes>
<o:Attribute Id="o100">
<a:ObjectID>8E297064-8F8B-4D45-BBCB-77C2B95A6FEB</a:ObjectID>
<a:Name>timestamp</a:Name>
<a:Code>timestamp</a:Code>
<a:CreationDate>1351539639</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539838</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>java.util.Timestamp</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o101">
<a:ObjectID>6060F564-9AA0-42E3-8510-595631BC9899</a:ObjectID>
<a:Name>agentRegularisateur</a:Name>
<a:Code>agentRegularisateur</a:Code>
<a:CreationDate>1351539639</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539838</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>Agent</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
<c:ObjectDataType>
<o:Class Ref="o21"/>
</c:ObjectDataType>
</o:Attribute>
<o:Attribute Id="o102">
<a:ObjectID>78F60C47-F3E0-428D-9F44-880237F574F4</a:ObjectID>
<a:Name>motifRegularisation</a:Name>
<a:Code>motifRegularisation</a:Code>
<a:CreationDate>1351539639</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539838</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>MotifRegularisation</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
<c:ObjectDataType>
<o:Class Ref="o37"/>
</c:ObjectDataType>
</o:Attribute>
<o:Attribute Id="o103">
<a:ObjectID>45092D23-2FA2-4109-8BC7-B7D18C3E806C</a:ObjectID>
<a:Name>erreurCaisseId</a:Name>
<a:Code>erreurCaisseId</a:Code>
<a:CreationDate>1351539639</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539838</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>int</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
<o:Attribute Id="o104">
<a:ObjectID>CB85CBFC-58E2-4C96-86BF-2DDB7DE4100E</a:ObjectID>
<a:Name>typeRegularisation</a:Name>
<a:Code>typeRegularisation</a:Code>
<a:CreationDate>1351539639</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539838</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>TypeRegularisation</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
<c:ObjectDataType>
<o:Class Ref="o33"/>
</c:ObjectDataType>
</o:Attribute>
<o:Attribute Id="o105">
<a:ObjectID>F16E60F0-D0C3-4587-AD1D-E13AB0A8D072</a:ObjectID>
<a:Name>montantRegularisation</a:Name>
<a:Code>montantRegularisation</a:Code>
<a:CreationDate>1351539639</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351539838</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:DataType>float</a:DataType>
<a:Attribute.Visibility>-</a:Attribute.Visibility>
</o:Attribute>
</c:Attributes>
</o:Class>
</c:Classes>
<c:Generalizations>
<o:Generalization Id="o9">
<a:ObjectID>61A05CCC-A20D-46E4-BD01-B56F97DA8AF1</a:ObjectID>
<a:Name>Generalisation_1</a:Name>
<a:Code>Generalisation_1</a:Code>
<a:CreationDate>1351538141</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538141</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<c:Object1>
<o:Class Ref="o21"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o22"/>
</c:Object2>
</o:Generalization>
<o:Generalization Id="o12">
<a:ObjectID>3D5E8C17-D8AC-4F8B-8DE2-F879C2A1ACE6</a:ObjectID>
<a:Name>Generalisation_2</a:Name>
<a:Code>Generalisation_2</a:Code>
<a:CreationDate>1351538143</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538143</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<c:Object1>
<o:Class Ref="o21"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o24"/>
</c:Object2>
</o:Generalization>
<o:Generalization Id="o15">
<a:ObjectID>E2082B51-8FE2-42B1-B9EE-39186AFAD3A8</a:ObjectID>
<a:Name>Generalisation_3</a:Name>
<a:Code>Generalisation_3</a:Code>
<a:CreationDate>1351538145</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538145</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<c:Object1>
<o:Class Ref="o22"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o23"/>
</c:Object2>
</o:Generalization>
<o:Generalization Id="o18">
<a:ObjectID>CDECEE89-199A-4C86-9126-257480EE02C3</a:ObjectID>
<a:Name>Generalisation_4</a:Name>
<a:Code>Generalisation_4</a:Code>
<a:CreationDate>1351538146</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351538146</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<c:Object1>
<o:Class Ref="o22"/>
</c:Object1>
<c:Object2>
<o:Class Ref="o25"/>
</c:Object2>
</o:Generalization>
</c:Generalizations>
<c:TargetModels>
<o:TargetModel Id="o106">
<a:ObjectID>1D27CEDF-DD45-4A3A-93D3-70313653313B</a:ObjectID>
<a:Name>Java</a:Name>
<a:Code>Java</a:Code>
<a:CreationDate>1351534514</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351534514</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:TargetModelURL>file:///%_OBJLANG%/java5-j2ee14.xol</a:TargetModelURL>
<a:TargetModelID>0DEDDB90-46E2-45A0-886E-411709DA0DC9</a:TargetModelID>
<a:TargetModelClassID>1811206C-1A4B-11D1-83D9-444553540000</a:TargetModelClassID>
<c:SessionShortcuts>
<o:Shortcut Ref="o3"/>
</c:SessionShortcuts>
</o:TargetModel>
<o:TargetModel Id="o107">
<a:ObjectID>DF26EAE8-0922-49CB-A34B-E241648657AD</a:ObjectID>
<a:Name>WSDL for Java</a:Name>
<a:Code>WSDLJava</a:Code>
<a:CreationDate>1351534514</a:CreationDate>
<a:Creator>Morgane</a:Creator>
<a:ModificationDate>1351534514</a:ModificationDate>
<a:Modifier>Morgane</a:Modifier>
<a:TargetModelURL>file:///%_XEM%/WSDLJ2EE.xem</a:TargetModelURL>
<a:TargetModelID>C8F5F7B2-CF9D-4E98-8301-959BB6E86C8A</a:TargetModelID>
<a:TargetModelClassID>186C8AC3-D3DC-11D3-881C-00508B03C75C</a:TargetModelClassID>
<c:SessionShortcuts>
<o:Shortcut Ref="o4"/>
</c:SessionShortcuts>
</o:TargetModel>
</c:TargetModels>
</o:Model>
</c:Children>
</o:RootObject>

</Model>