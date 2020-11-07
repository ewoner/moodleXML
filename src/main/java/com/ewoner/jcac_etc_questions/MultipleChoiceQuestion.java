class MultipleChoiceQuestion extends Question {
	
	private boolean single;
	private boolean shuffeAnswers;
	private String correctFeedback;
	private String partiallyCorrectFeedback;
	private AnswerNumberingEnum answerNumbering;
	
	private List<Answers> answers;
}