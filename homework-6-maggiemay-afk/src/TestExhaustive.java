import edu.uwm.apc430.Card;
import edu.uwm.apc430.CardUtil;
import junit.framework.TestCase;

public class TestExhaustive extends TestCase {
  private Card.Group g;
  private Card s1, s2, s3, s4, s5, s6;

  @Override
  protected void setUp() {
    s1 = new Card(Card.Rank.DEUCE,Card.Suit.CLUB);
    s2 = new Card(Card.Rank.TEN,Card.Suit.CLUB);
    s3 = new Card(Card.Rank.JACK,Card.Suit.CLUB);
    s4 = new Card(Card.Rank.QUEEN,Card.Suit.CLUB);
    s5 = new Card(Card.Rank.KING,Card.Suit.CLUB);
    s6 = new Card(Card.Rank.ACE,Card.Suit.CLUB);
    g = new Card.Group();
   }

  public void test1001() {
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
  }

  public void test2001() {
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
  }

  public void test2002() {
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
  }

  public void test3001() {
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
  }

  public void test3002() {
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
  }

  public void test3003() {
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
  }

  public void test3004() {
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
  }

  public void test3005() {
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
  }

  public void test3006() {
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
  }

  public void test4001() {
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4002() {
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4003() {
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4004() {
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4005() {
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4006() {
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4007() {
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4008() {
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4009() {
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4010() {
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4011() {
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4012() {
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4013() {
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4014() {
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4015() {
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4016() {
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4017() {
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4018() {
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4019() {
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4020() {
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4021() {
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4022() {
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4023() {
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test4024() {
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
  }

  public void test5001() {
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5002() {
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5003() {
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5004() {
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5005() {
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5006() {
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5007() {
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5008() {
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5009() {
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5010() {
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5011() {
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5012() {
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5013() {
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5014() {
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5015() {
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5016() {
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5017() {
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5018() {
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5019() {
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5020() {
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5021() {
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5022() {
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5023() {
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5024() {
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5025() {
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5026() {
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5027() {
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5028() {
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5029() {
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5030() {
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5031() {
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5032() {
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5033() {
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5034() {
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5035() {
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5036() {
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5037() {
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5038() {
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5039() {
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5040() {
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5041() {
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5042() {
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5043() {
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5044() {
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5045() {
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5046() {
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5047() {
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5048() {
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5049() {
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5050() {
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5051() {
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5052() {
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5053() {
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5054() {
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5055() {
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5056() {
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5057() {
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5058() {
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5059() {
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5060() {
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5061() {
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5062() {
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5063() {
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5064() {
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5065() {
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5066() {
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5067() {
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5068() {
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5069() {
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5070() {
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5071() {
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5072() {
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5073() {
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5074() {
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5075() {
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5076() {
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5077() {
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5078() {
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5079() {
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5080() {
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5081() {
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5082() {
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5083() {
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5084() {
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5085() {
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5086() {
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5087() {
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5088() {
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5089() {
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5090() {
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5091() {
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5092() {
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5093() {
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5094() {
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5095() {
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5096() {
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5097() {
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5098() {
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5099() {
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5100() {
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5101() {
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5102() {
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5103() {
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5104() {
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5105() {
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5106() {
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5107() {
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5108() {
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5109() {
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5110() {
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5111() {
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5112() {
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5113() {
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5114() {
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5115() {
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5116() {
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5117() {
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5118() {
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5119() {
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test5120() {
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
  }

  public void test6001() {
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6002() {
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6003() {
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6004() {
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6005() {
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6006() {
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6007() {
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6008() {
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6009() {
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6010() {
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6011() {
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6012() {
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6013() {
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6014() {
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6015() {
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6016() {
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6017() {
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6018() {
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6019() {
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6020() {
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6021() {
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6022() {
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6023() {
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6024() {
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6025() {
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6026() {
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6027() {
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6028() {
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6029() {
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6030() {
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6031() {
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6032() {
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6033() {
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6034() {
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6035() {
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6036() {
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6037() {
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6038() {
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6039() {
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6040() {
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6041() {
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6042() {
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6043() {
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6044() {
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6045() {
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6046() {
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6047() {
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6048() {
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6049() {
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6050() {
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6051() {
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6052() {
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6053() {
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6054() {
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6055() {
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6056() {
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6057() {
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6058() {
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6059() {
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6060() {
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6061() {
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6062() {
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6063() {
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6064() {
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6065() {
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6066() {
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6067() {
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6068() {
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6069() {
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6070() {
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6071() {
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6072() {
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6073() {
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6074() {
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6075() {
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6076() {
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6077() {
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6078() {
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6079() {
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6080() {
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6081() {
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6082() {
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6083() {
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6084() {
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6085() {
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6086() {
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6087() {
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6088() {
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6089() {
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6090() {
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6091() {
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6092() {
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6093() {
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6094() {
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6095() {
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6096() {
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6097() {
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6098() {
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6099() {
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6100() {
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6101() {
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6102() {
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6103() {
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6104() {
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6105() {
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6106() {
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6107() {
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6108() {
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6109() {
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6110() {
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6111() {
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6112() {
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6113() {
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6114() {
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6115() {
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6116() {
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6117() {
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6118() {
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6119() {
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6120() {
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6121() {
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6122() {
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6123() {
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6124() {
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6125() {
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6126() {
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6127() {
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6128() {
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6129() {
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6130() {
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6131() {
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6132() {
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6133() {
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6134() {
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6135() {
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6136() {
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6137() {
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6138() {
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6139() {
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6140() {
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6141() {
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6142() {
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6143() {
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6144() {
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6145() {
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6146() {
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6147() {
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6148() {
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6149() {
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6150() {
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6151() {
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6152() {
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6153() {
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6154() {
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6155() {
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6156() {
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6157() {
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6158() {
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6159() {
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6160() {
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6161() {
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6162() {
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6163() {
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6164() {
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6165() {
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6166() {
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6167() {
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6168() {
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6169() {
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6170() {
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6171() {
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6172() {
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6173() {
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6174() {
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6175() {
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6176() {
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6177() {
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6178() {
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6179() {
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6180() {
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6181() {
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6182() {
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6183() {
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6184() {
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6185() {
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6186() {
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6187() {
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6188() {
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6189() {
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6190() {
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6191() {
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6192() {
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6193() {
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6194() {
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6195() {
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6196() {
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6197() {
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6198() {
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6199() {
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6200() {
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6201() {
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6202() {
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6203() {
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6204() {
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6205() {
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6206() {
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6207() {
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6208() {
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6209() {
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6210() {
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6211() {
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6212() {
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6213() {
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6214() {
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6215() {
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6216() {
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6217() {
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6218() {
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6219() {
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6220() {
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6221() {
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6222() {
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6223() {
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6224() {
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6225() {
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6226() {
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6227() {
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6228() {
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6229() {
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6230() {
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6231() {
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6232() {
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6233() {
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6234() {
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6235() {
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6236() {
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6237() {
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6238() {
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6239() {
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6240() {
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6241() {
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6242() {
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6243() {
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6244() {
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6245() {
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6246() {
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6247() {
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6248() {
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6249() {
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6250() {
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6251() {
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6252() {
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6253() {
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6254() {
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6255() {
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6256() {
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6257() {
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6258() {
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6259() {
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6260() {
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6261() {
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6262() {
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6263() {
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6264() {
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6265() {
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6266() {
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6267() {
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6268() {
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6269() {
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6270() {
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6271() {
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6272() {
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6273() {
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6274() {
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6275() {
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6276() {
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6277() {
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6278() {
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6279() {
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6280() {
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6281() {
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6282() {
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6283() {
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6284() {
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6285() {
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6286() {
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6287() {
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6288() {
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6289() {
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6290() {
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6291() {
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6292() {
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6293() {
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6294() {
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6295() {
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6296() {
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6297() {
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6298() {
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6299() {
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6300() {
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6301() {
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6302() {
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6303() {
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6304() {
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6305() {
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6306() {
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6307() {
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6308() {
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6309() {
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6310() {
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6311() {
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6312() {
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6313() {
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6314() {
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6315() {
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6316() {
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6317() {
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6318() {
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6319() {
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6320() {
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6321() {
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6322() {
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6323() {
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6324() {
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6325() {
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6326() {
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6327() {
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6328() {
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6329() {
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6330() {
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6331() {
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6332() {
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6333() {
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6334() {
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6335() {
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6336() {
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6337() {
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6338() {
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6339() {
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6340() {
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6341() {
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6342() {
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6343() {
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6344() {
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6345() {
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6346() {
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6347() {
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6348() {
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6349() {
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6350() {
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6351() {
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6352() {
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6353() {
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6354() {
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6355() {
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6356() {
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6357() {
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6358() {
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6359() {
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6360() {
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6361() {
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6362() {
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6363() {
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6364() {
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6365() {
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6366() {
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6367() {
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6368() {
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6369() {
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6370() {
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6371() {
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6372() {
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6373() {
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6374() {
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6375() {
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6376() {
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6377() {
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6378() {
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6379() {
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6380() {
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6381() {
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6382() {
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6383() {
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6384() {
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6385() {
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6386() {
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6387() {
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6388() {
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6389() {
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6390() {
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6391() {
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6392() {
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6393() {
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6394() {
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6395() {
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6396() {
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6397() {
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6398() {
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6399() {
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6400() {
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6401() {
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6402() {
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6403() {
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6404() {
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6405() {
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6406() {
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6407() {
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6408() {
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6409() {
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6410() {
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6411() {
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6412() {
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6413() {
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6414() {
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6415() {
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6416() {
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6417() {
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6418() {
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6419() {
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6420() {
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6421() {
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6422() {
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6423() {
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6424() {
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6425() {
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6426() {
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6427() {
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6428() {
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6429() {
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6430() {
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6431() {
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6432() {
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6433() {
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6434() {
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6435() {
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6436() {
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6437() {
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6438() {
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6439() {
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6440() {
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6441() {
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6442() {
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6443() {
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6444() {
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6445() {
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6446() {
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6447() {
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6448() {
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6449() {
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6450() {
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6451() {
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6452() {
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6453() {
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6454() {
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6455() {
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6456() {
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6457() {
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6458() {
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6459() {
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6460() {
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6461() {
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6462() {
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6463() {
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6464() {
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6465() {
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6466() {
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6467() {
    g.add(s1);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6468() {
    g.add(s4);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6469() {
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6470() {
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6471() {
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6472() {
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6473() {
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6474() {
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6475() {
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6476() {
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6477() {
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6478() {
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6479() {
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6480() {
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6481() {
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6482() {
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6483() {
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6484() {
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6485() {
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6486() {
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6487() {
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6488() {
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6489() {
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6490() {
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6491() {
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6492() {
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6493() {
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6494() {
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6495() {
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6496() {
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6497() {
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6498() {
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6499() {
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6500() {
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6501() {
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6502() {
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6503() {
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6504() {
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6505() {
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6506() {
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6507() {
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6508() {
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6509() {
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6510() {
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6511() {
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6512() {
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6513() {
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6514() {
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6515() {
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6516() {
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6517() {
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6518() {
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6519() {
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6520() {
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6521() {
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6522() {
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6523() {
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6524() {
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6525() {
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6526() {
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6527() {
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6528() {
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6529() {
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6530() {
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6531() {
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6532() {
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6533() {
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6534() {
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6535() {
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6536() {
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6537() {
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6538() {
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6539() {
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6540() {
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6541() {
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6542() {
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6543() {
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6544() {
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6545() {
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6546() {
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6547() {
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6548() {
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6549() {
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6550() {
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6551() {
    g.add(s1);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6552() {
    g.add(s3);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6553() {
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6554() {
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6555() {
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6556() {
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6557() {
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6558() {
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6559() {
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6560() {
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6561() {
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6562() {
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6563() {
    g.add(s1);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6564() {
    g.add(s2);
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6565() {
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6566() {
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6567() {
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6568() {
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6569() {
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6570() {
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6571() {
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6572() {
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6573() {
    g.add(s1);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6574() {
    g.add(s5);
    g.add(s1);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6575() {
    g.add(s6);
    g.add(s1);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6576() {
    g.add(s1);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6577() {
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6578() {
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6579() {
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6580() {
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6581() {
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6582() {
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6583() {
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6584() {
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6585() {
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6586() {
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6587() {
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6588() {
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6589() {
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6590() {
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6591() {
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6592() {
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6593() {
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6594() {
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6595() {
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6596() {
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6597() {
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6598() {
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6599() {
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6600() {
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.add(s4);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6601() {
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6602() {
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6603() {
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6604() {
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6605() {
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6606() {
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6607() {
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6608() {
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6609() {
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6610() {
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6611() {
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6612() {
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6613() {
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6614() {
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6615() {
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6616() {
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6617() {
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6618() {
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6619() {
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6620() {
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6621() {
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6622() {
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6623() {
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6624() {
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6625() {
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6626() {
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6627() {
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6628() {
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6629() {
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6630() {
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6631() {
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6632() {
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6633() {
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6634() {
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6635() {
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6636() {
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6637() {
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6638() {
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6639() {
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6640() {
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6641() {
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6642() {
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6643() {
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6644() {
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6645() {
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6646() {
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6647() {
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6648() {
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6649() {
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6650() {
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6651() {
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6652() {
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6653() {
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6654() {
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6655() {
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6656() {
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6657() {
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6658() {
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6659() {
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6660() {
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6661() {
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6662() {
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6663() {
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6664() {
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6665() {
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6666() {
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6667() {
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6668() {
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6669() {
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6670() {
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6671() {
    g.add(s6);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6672() {
    g.add(s3);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6673() {
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6674() {
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6675() {
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6676() {
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6677() {
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6678() {
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6679() {
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6680() {
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6681() {
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6682() {
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6683() {
    g.add(s6);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6684() {
    g.add(s2);
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6685() {
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6686() {
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6687() {
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6688() {
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6689() {
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6690() {
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6691() {
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6692() {
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6693() {
    g.add(s6);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6694() {
    g.add(s5);
    g.add(s6);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6695() {
    g.add(s4);
    g.add(s6);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6696() {
    g.add(s6);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6697() {
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6698() {
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6699() {
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6700() {
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6701() {
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6702() {
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6703() {
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6704() {
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6705() {
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6706() {
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6707() {
    g.add(s4);
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6708() {
    g.add(s3);
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6709() {
    g.add(s3);
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6710() {
    g.add(s5);
    g.add(s3);
    g.add(s2);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6711() {
    g.add(s2);
    g.add(s3);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6712() {
    g.add(s3);
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6713() {
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6714() {
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s4);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6715() {
    g.add(s2);
    g.add(s5);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6716() {
    g.add(s5);
    g.add(s2);
    g.add(s4);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6717() {
    g.add(s4);
    g.add(s2);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6718() {
    g.add(s2);
    g.add(s4);
    g.add(s5);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6719() {
    g.add(s5);
    g.add(s4);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

  public void test6720() {
    g.add(s4);
    g.add(s5);
    g.add(s2);
    g.add(s3);
    g.add(s6);
    g.add(s1);
    g.sort(CardUtil.acesHigh);
    assertSame(s1,g.draw());
    assertSame(s2,g.draw());
    assertSame(s3,g.draw());
    assertSame(s4,g.draw());
    assertSame(s5,g.draw());
    assertSame(s6,g.draw());
  }

}
