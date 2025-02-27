package green.mtcoding.travel.scrap;

import green.mtcoding.travel.user.User;
import green.mtcoding.travel.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ScrapService {

    private final ScrapRepository scrapRepository;

    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */
    /*           hotPlace-end             */

    /*           festival-start             */
    /*           festival-end             */

    /*           info-start             */
    /*           info-end             */

    /*           map-start             */
    /*           map-end             */

    /*           user-start             */
    /*           user-end             */

    /*           myPage-start             */
    public ScrapResponse.MypageScrapDTO mypageSelectScrap(User sessionUser) {
        // 1. 유저 id를 가지고 스크랩 목록 가져오기
        int id = sessionUser.getId();
        List<ScrapResponse.ScrapListDTO> scrapList = scrapRepository.scrapFindByUserId(id);
        List<ScrapResponse.MypageUserDTO> userInfo = scrapRepository.userFindById(id);
        return new ScrapResponse.MypageScrapDTO(scrapList, userInfo);
        // 2. 스크랩 목록 유무 판단

    }

    // 스크랩 OnOff
    @Transactional
    public String scrapOnOff(User sessionUser, String contentId){
        int userId = sessionUser.getId();
        try{
            Boolean bl = scrapRepository.scrapFindByContentId(userId,contentId);
            if (bl == true){
                scrapRepository.scrapOffById(userId,contentId);
                return "off";
            } else if (bl == false) {
                scrapRepository.scrapOnById(userId,contentId);
            }
            return "on";
        } catch (NullPointerException e){
            scrapRepository.scrapInsertById(userId, contentId);
            return "on";
        }

        // 스크랩이 존재하는지


    }
    // 1. 유저 세션 체크

    /*           myPage-end             */
}
