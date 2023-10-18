Python 3.2.3 (default, Apr 11 2012, 07:15:24) [MSC v.1500 32 bit (Intel)] on win32
Type "copyright", "credits" or "license()" for more information.
>>> s = "Um tigre, dois tigre, tres tigre"
>>> s.replace('tigre','gato') #troca tigre por gato
'Um gato, dois gato, tres gato'
>>> s
'Um tigre, dois tigre, tres tigre'
>>> #Porém não altera a string "s"
>>> #para alterar, necessita atribuir novo valor em outra variavel
>>> s = s.replace('tigre','gato')
>>> s
'Um gato, dois gato, tres gato'
>>> txt = "Batatinha quando nasce"
>>> txt.split()
['Batatinha', 'quando', 'nasce']
>>> data = "210"
>>> data = "21/02/2011"
>>> data.split ('/')
['21', '02', '2011']
>>> #separador, ele quebra uma variavel, fazendo uma atribuição automática
>>> #só funciona com STRING caraiii
>>> times = ["QUERO", "SABER", "TRANZA", "CHUPA", "UM", "CÚ", "E", "PAH"]
>>> "/".join(times)
'QUERO/SABER/TRANZA/CHUPA/UM/CÚ/E/PAH'
>>> 
listaA = '''bbzvs bbdqpvn bplzzpjw bpngkf blnw blx bmt bmzqtdx brprszrc brzxg brxk bsb
bslbmwm bfjbs bfjmw bzccxd bzrznlh bzfqkpjj bzqcnzwp bhrfvh bjgllxv bwfgzmjn bkjcm
bvrjztfm bdjxr bdnfbh bghqpnl cbk cbkgf ccx cpcnpnww cltdd cmrgdh cmsqdjx cmvjrf cmgp
crbhzfs cstjtb czhhtclr chbb chv cncdbm cnpqtw cwmb cwkc cxpplqbq ckxtmqx cqw cvhxd
cdswmbgb cdxsgqgs cgcdvbpt cgp cgpn cgrtr tbw ttl ttjtx tpppxf tplwbr tpvdrlf tlthnhrh
tmjlqw trzz trxl trvpx tsmrhhtm tzhqvbt tzwvbkfq tzqcvz tzd tjpdp tjw tjgmjzh tnbqgv
tnt twjhgcc twxcfxk txz tkljpkfc tqbs tvphkg tvpjwzb tdbsgf tdsbdhv tdjzcwj tgtclv
tgmwmsc tgsffh tgjpq tgnq tgq pbmp pctgq pcl pcvpwjb ptmzl ptmnzqkg ptg ppsp ppzpvfbv
pphslgf plphnnv pljpvcn plkxf pmmd pmnt pmgtzlng psjc pfcpt pfcgz pfkjshg pznlvfk phbq
phn phk pjcjzct pnhc pwpznr pxcpvkmm pkqxrsw pqc pqsq pvf pdfqlsv pdhqn pdnqm pdxjxpxr
pgbkhc pgjjhr pgwd lbbkssx lbrnrsf lbkw lbqjrp ltjwn ltqxkt lphf lllkssb llshm lljs
lmbtkhch lmbfvsv lmbjjx lmknq lmq lrljqdct lsmphpk lfhkmb lfjvrhr lzhr lzq lzgfnkmg
ljxh ljdz lnt lnkfqjt lwlqdh lwdbkws lxtf lxzscps lxkmnzx lqmtsnrn lqncvrh lqg lvwht
lvq lvqckrl lgf lgh mbccsd mbzkdw mbd mclvp mcld mtrfm mpqxtbzb mlsm mlfmddsn mmj mmksm
mrddntg mfm mfhllb mhcskk mhlrmd mhj mjhskxjh mjwrncd mxjccgv mxqhpg mkt mkmnwtzv mkszj
mkfsfcwd mqfsrwt mqdgvskt mdcqlbwx mdrgqdht mdz mdxlzvkg mdkc mdvcfqkt rbr rcfxhhh rtb
rtm rtxct rpxwnbrw rmmhtmbp rrflt rskfms rsqb rsd rflzw rfqsr rfqdh rzp rhhmzvp
rjldhzld rwtzbhs rwtxljp rwjls rxrmqp rkzlhbnx rkvg rqm rqkr rdrphff rgtrj rgpgqz
sbrkdjmh sbst sbnfjs spzzbc smtkrxjx smdlrm srtfttv srwg sfwsnkkw szbmqd szltzjm szzh
swff sxcdqtlt sklfrc skhcwxw skwkh skxpc skkfq svztn fcppm ftfpd ftzkqg ftdqspbf
fpbwbzb fpj frtvg frp frs frskk fsp fshm fzlxll fjmt fwwm fwqwfxs fkmrtn fkzql fqppvgk
fvjdqd fvntg fdsfsc fdh fgmcd fgrfb fgvsxzp zbmclc zbrpktxj zbdbsq zcjjttpt ztm ztvkmv
zlmtqs zldk zmnc zflwbn zzrr zhzvm zjcrkzm zjqcbxf znngdwb znktlpx zndtfmf zwwx zwwdsd
zwvwrnn zxljnd zkf zqwb zvtnbs zdrfjwc zgl zgnlpgwl zgqxqpvm hbtjpvm hbff hcr htldnxcn
htkmdbx hphvdvl hljqwkz hlnls hlxx hlkxtc hmnf hrdqrds hsc hffjd hzrv hzdb hhcxnnhn
hhrrx hwfbd hxr hqlgx hdslhv hdj hgsx jbmlsfkx jbnplx jbnw jbw jbvqmb jcw jtmdmt
jtwhxdx jplzc jlhpgh jlgz jmstqwx jmqkbclx jsfpllns jsfkd jfmcl jfhhv jfxzx jzrr jzzpb
jzdfqq jhtxc jhztz jjqn jntktdz jxsd jxnng jkk jqbcddqh jqjgd jvcmkbxv jvkwr jvvc jgl
jgw nbkvsrf ncrmzr nlbcwrvv nlvgr nmc nmmqnzfn nmdzgmnr nrpzqfr nsx nfhvn nfkltv nfvnjfqrzxj njq njqw njv nwjjkrdq nkjk nqbh nqjflf nvb nvmfhshh ndtbsqsh ngc ngsbphqb
ngwrbrfk ngkgnln ngqzs wbcjprr wbht wcc wcptgbc wcpn wcjlrs wtlsx wtsp wtfh wthwv wptc
wpfl wlsxsvf wlj wmvjxdsw wrsctd wrzct wrgf wffrgzp wfqxrnzf wzb wzfsf wzg whshcrk
whnjkv wjg wnlmw wwmngbk wxxchz wknwbcq wkq wdc wdxmfr xblfrb xtdzrz xpbddsjw xlc
xldsnqds xmtzz xrsrjv xrqhp xftg xfpj xffjdlfs xhjk xwxjhbc xxcfpp xxtlt xxzdlwzx xqbs
xvqnd xvgkv xdlsm xgj xggzgkln kbg kcr kcxl kcdwcpdm ktbcx kpbslq kpmmgxb kmbgdwm kmk
krprtxf krh krdb ksptr kslnx kszjq kswfwbzv kztrcqxt kzzsbq khlbtg khzzw khhmfng khqr
knlwvk knhmmtks kwchwcv kwhcrd kwvnrfm kkrr kknhkq kqzrlxz kvtgzpl kgzsb kgj qbpsv
qbvvz qcrx qcxr qlpt qlmhxrrf qmwknt qslm qsfctn qfbrdg qzz qzj qhvszv qjlmkkmv qjvg
qnghqcch qwl qkkjgg qdr qdht qddg qdgqls qgsvbgws vcj vcvccs vttn vth vmpdxkv vmhp
vmqzmg vmd vsrp vsng vfb vftnnd vhxdj vjmmf vjq vwmb vwddsdl vxpbxrdj vxf vkffrqvt
vkvqhk vqbq vqdmjdsb vvsvkq vdbbxdtw vdszkb vgclcmdx vglkdghk vghjwkvl dcrzslrf dcsbhwp
dcxsrkl dckqls dcgxxcqm dtblv dtrsfb dpl dlbnhz dmp dsgnhsf dfbnht dfctpgr dfj dfvt
djbgqqk djsv djftp dwlrgxtm dwsk dxpx dxmkk dxss dxz dkzxctcn dknttlb dqfjwtv dvmj
dgrhmgn dgsxl dgwd dggshkxz gbprtv gbn gcmdfzdx gcnzl gcnkszfk gtrpzhwb gthkq gtvrwp
gpn gmv grplms gscvghmj gsrxcb gsqfgjn gfc gzrq ghfntj gjbbg gjw gjvnj gnksf gwpcph
gxltm gxglr gkt gkh gkhp gqhdfchv gqjjcbjw gqwxpncw gvbfxtbv gvhkcsvw gvwg ggzb ggvf
ggd'''.split()
