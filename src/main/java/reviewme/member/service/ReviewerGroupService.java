package reviewme.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reviewme.member.domain.Member;
import reviewme.member.domain.ReviewerGroup;
import reviewme.member.dto.response.MemberResponse;
import reviewme.member.dto.response.ReviewerGroupResponse;
import reviewme.member.repository.ReviewerGroupRepository;

@Service
@RequiredArgsConstructor
public class ReviewerGroupService {

    private final ReviewerGroupRepository reviewerGroupRepository;

    public ReviewerGroupResponse findReviewerGroup(long reviewerGroupId) {
        ReviewerGroup reviewerGroup = reviewerGroupRepository.getReviewerGroupById(reviewerGroupId);
        Member reviewee = reviewerGroup.getReviewee();
        return new ReviewerGroupResponse(
                reviewerGroup.getId(),
                reviewerGroup.getGroupName(),
                reviewerGroup.getDeadline(),
                new MemberResponse(reviewee.getId(), reviewee.getName())
        );
    }
}
