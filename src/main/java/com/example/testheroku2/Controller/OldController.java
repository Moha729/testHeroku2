package com.example.testheroku2.Controller;

/*
@Controller
public class OldController {

    @Autowired
    MemberService memberService;
    @Autowired
    CleaningService cleaningService;
    @Autowired
    WeekService weekService;

    @GetMapping("/")
    public String getInd(Model model, Model model2, Model model3){

        if (weekNumb.getWeekNumb() == 0){
            System.out.println("Week numb is "+weekNumb.getWeekNumb());
            weekNumb.setWeekNumb(weekService.getBeforeWeek());
            System.out.println("Week numb is set to: "+weekNumb.getWeekNumb());
        }

        List<CleaningArea> areas = cleaningService.fetchAllSections();


        model.addAttribute("MembersList", testMembers(areas));
        model2.addAttribute("sectionsList", areas);
        model3.addAttribute("displayWeek", weekNumb.getWeekNumb());
        return "index4";
    }

    WeekNumberWrapper weekNumb = new WeekNumberWrapper();


    @PostMapping("/")//DONT CAll a post method GET???
    public String getWeekNumber(@ModelAttribute WeekNumberWrapper weekNumb){
        //System.out.println(weekNumb.getWeekNumb()+" weekNumb");
        this.weekNumb = weekNumb;
        weekService.updateWeek(weekNumb.getWeekNumb());
        return "redirect:/";
    }*/
/*
    public ArrayList<Member> testMembers (/*int weekNumber List<CleaningArea> areas) {
        ArrayList<Member> members = new ArrayList<>();
        List<Member> readMembers = memberService.fetchAll();
        for (int i = 0; i < readMembers.size(); i++) {
            members.add(readMembers.get(i));
        }
        for (int i = readMembers.size(); i < 16; i++) {
            Member newMember = new Member();
            newMember.setMemberName("person" + (i+1));
            members.add(newMember);
        }

        for (int i = areas.size(); i < members.size(); i++) {
            CleaningArea cleaningArea = new CleaningArea();
            cleaningArea.setSectionName("Off week");
            System.out.println(cleaningArea.getSectionName()+i+" print 1");
            areas.add(cleaningArea);
            System.out.println(areas.get(i).getSectionName()+" print 2");
        }

        if (weekNumb.getWeekNumb() == 0){
            System.out.println("Week numb is "+weekNumb.getWeekNumb());
            weekNumb.setWeekNumb(weekService.getBeforeWeek());
            System.out.println("Week numb is set to: "+weekNumb.getWeekNumb());
        }
        ArrayList<Integer> noObjectProblemSetMemberIdToForeignKeys = new ArrayList<>();
        int primitiveWeekCount = (weekNumb.getWeekNumb() - 23);
        int k = 0;
        for (int j = 0; j < primitiveWeekCount; j++) {
            System.out.println("Week " + (j + 1));

            if (j != 0) {
                k = members.size() - j;
            }
            for (int i = 0; i < members.size(); i++) {
                if (k >= members.size()) {
                    k = 0 ;
                }
                if (i >= areas.size()) {
                    System.out.println("O " + members.get( k).getMemberName());
                } else {
                    //System.out.println(areas.get(i) + " " + members.get(k));
                    areas.get(i).setAssignedTo(members.get(k).getMemberName());
                    System.out.println("name: "+ members.get(k).getMemberName()
                            + " id: "+ members.get(k).getMemberId());

                    int noObjectProblemSetMemberIdToForeignKey = members.get(k).getMemberId();

                    if (noObjectProblemSetMemberIdToForeignKey == members.get(k).getMemberId())
                    {
                        noObjectProblemSetMemberIdToForeignKeys.add(noObjectProblemSetMemberIdToForeignKey);
                    }
                }
                k++;
            }
        }
        setAssignedTo((ArrayList<CleaningArea>) areas, noObjectProblemSetMemberIdToForeignKeys);
        return members;
    }
    public void setAssignedTo(ArrayList<CleaningArea> areas, ArrayList<Integer> noObjectProblemSetMemberIdToForeignKeys){
        for (int i = 0; i < areas.size(); i++) {
            System.out.println("Areas size in controller "+areas.size());
            System.out.println("And the member Id I want to take with: "+ noObjectProblemSetMemberIdToForeignKeys.size());
            cleaningService.setAssignedTo(areas.get(i).getSectionId(), noObjectProblemSetMemberIdToForeignKeys.get(i), weekService.getBeforeWeek());
            System.out.println("THe relation between "+ areas.get(i).getSectionId() + " and "+ noObjectProblemSetMemberIdToForeignKeys.get(i));
        }
    }


 */

/*    @GetMapping("/set-done-by/{sectionID}")
    public String setDoneBy(@PathVariable("sectionID") int id, Model model){
        List<CleaningArea> areas = cleaningService.fetchAllSections();
        System.out.println(id);
        model.addAttribute("oneArea", areas.get(id)cleaningService.findById(id));
        model.addAttribute("membersList", testMembers(areas));
        return "cleaning/set-done-by";
    }*/




/*    @GetMapping("/new-member")
    public String newMember (){
        return "new-member";
    }

    @PostMapping("/new-member")
    public String newMember (@ModelAttribute Member member) {
        memberService.addNew(member);
        return "redirect:/";
    }*/

/*//    @GetMapping("/new")
//    public String getInd2(){
//        return "index2";
//    }

}*/
